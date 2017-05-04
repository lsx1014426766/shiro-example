package com.github.zhangkaitao.shiro.chapter5.hash;

import junit.framework.Assert;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.*;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Shiro 提供了 base64和 16 进制字符串编码/解码的 API支持，方便一些编码解码操作。
 * Shiro内部的一些数据的存储/表示都使用了 base64和 16 进制字符串。
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-27
 * <p>Version: 1.0
 */
public class CodecAndCryptoTest {



    @Test
    public void testBase64() {
        String str = "hello";
        //shiro提供的base64加密包  测试base64的加解密方法
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        Assert.assertEquals(str, str2);

    }

    @Test
    public void testHex() {
        String str = "hello";
        String base64Encoded = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base64Encoded.getBytes()));
        Assert.assertEquals(str, str2);

    }

    @Test
    public void testCodecSupport() {
        String str = "hello";
        byte[] bytes = CodecSupport.toBytes(str, "utf-8");
        String str2 = CodecSupport.toString(bytes, "utf-8");
        Assert.assertEquals(str, str2);
    }


    @Test
    public void testRandom() {
        //生成随机数
        SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());
        System.out.println(randomNumberGenerator.nextBytes().toHex());//16进制 32位
    }

    /**
     * Hash存储

     散列算法一般用于生成数据的摘要信息，
     是一种不可逆的算法，一般适合存储密码之类的数据，常见的散列算法如 MD5、SHA等
     一般进行散列时最好提供一个 salt（盐），比如加密密码“admin”，产生的散列值是“21232f297a57a5a743894a0e4a801fc3”，
     可以到一些 md5解密网站很容易的通过散列值得到密码“admin”，
     即如果直接对密码进行散列相对来说破解更容易，
     此时我们可以加一些只有系统知道的干扰数据，如用户名和 ID（即盐）；
     这样散列的对象是“密码+用户名+ID”，这样生成的散列值相对来说更难破解。
     散列时还可以指定散列次数，如 2次表示：md5(md5(str))：“new Md5Hash(str, salt, 2).toString()
     */

    @Test
    public void testMd5() {
        String str = "hello";
        String salt = "123";
        //Md5Hash(source,salt)
        String md5 = new Md5Hash(str, salt).toString();//还可以转换为 toBase64()/toHex()
       //86fcb4c0551ea48ede7df5ed9626eee7
        System.out.println(md5);


    }

    @Test
    public void testSha1() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha1Hash(str, salt).toString();
        //f0a139408f7b134c66342e3d1cf4870a293c11c3
        System.out.println(sha1);

    }

    @Test
       public void testSha256() {//64位
        String str = "123";
        String salt = "123";
        String sha1 = new Sha256Hash(str, salt).toString();
        //7dfe54ea69b2d07a597952e49374a1aebf3c10689444a83f0a084761c8a1c626
        System.out.println(sha1);

    }

    @Test
    public void testSha384() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha384Hash(str, salt).toString();
        //b18fad48be86ede658ae8b850137757d630772726f7ed70c2439cf42d536d9d20c0f377b546c49639586217b72c41077
        System.out.println(sha1);

    }

    @Test
    public void testSha512() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha512Hash(str, salt).toString();
        System.out.println(sha1);

    }

    /**
     * Shiro 还提供了通用的散列支持
     * 通过调用 SimpleHash 时指定散列算法，其内部使用了 Java的 MessageDigest 实现
     */
    @Test
    public void testSimpleHash() {
        String str = "hello";
        String salt = "123";
        //MessageDigest
        String simpleHash = new SimpleHash("SHA-1", str, salt).toString();
        System.out.println(simpleHash);

    }


    /**
     * 为了方便使用，Shiro提供了 HashService，默认提供了 DefaultHashService实现
     */
    @Test
    public void testHashService() {
        DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个
        hashService.setHashIterations(1); //生成Hash值的迭代次数

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }

    /**
     * 加密存储

     Shiro 还提供对称式加密/解密算法的支持，如 AES、Blowfish
     */

    @Test
    public void testAesCipherService() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);//设置key长度

        //生成key
        Key key = aesCipherService.generateNewKey();

        String text = "hello";

        //加密
        String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        Assert.assertEquals(text, text2);
    }

    @Test
    public void testBlowfishCipherService() {
        BlowfishCipherService blowfishCipherService = new BlowfishCipherService();
        blowfishCipherService.setKeySize(128);

        //生成key  先设置key的长度 再生成key
        Key key = blowfishCipherService.generateNewKey();

        String text = "hello";

        //加密
        String encrptText = blowfishCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 = new String(blowfishCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        Assert.assertEquals(text, text2);
    }

    /**
     * 是上面两种对称加解密算法的一个通用方法
     * @throws Exception
     */
    @Test
    public void testDefaultBlockCipherService() throws Exception {


        //对称加密，使用Java的JCA（javax.crypto.Cipher）加密API，常见的如 'AES', 'Blowfish'
        DefaultBlockCipherService cipherService = new DefaultBlockCipherService("AES");
        cipherService.setKeySize(128);

        //生成key
        Key key = cipherService.generateNewKey();

        String text = "hello";

        //加密
        String encrptText = cipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 = new String(cipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        Assert.assertEquals(text, text2);
    }


    //加密/解密相关知识可参考snowolf的博客 http://snowolf.iteye.com/category/68576
@Test
    public void test1(){
    //使用shiro提供的加密方法，对明文密码加密得到加密后的散列密码存储到db中
    //在进行密码验证时使用passwordMatcher
        DefaultPasswordService s= new DefaultPasswordService();
   // $shiro1$SHA-512$1$$PJkJr+wlNU1VHa4hWQuybjjVPyFzuNPcPu5MBH56scHri4UQPjvnumE7MbtcnDYhTcnxSkL9ei/bhIVrylxEwg==
    //$shiro1$SHA-256$500000$jUVPZ8B9LgvaTVRgo2dyPA==$LwxkBtM4SG7bwgq/VBAMrm9SYiXWNLpGxzCgs2qDenM=
        System.out.println(s.encryptPassword("123"));
    }
}
