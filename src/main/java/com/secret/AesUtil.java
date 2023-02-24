package com.secret;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-02-24
 * Time: 14:20
 *
 * @author nero
 */
public class AesUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    // 加密秘钥
    private static final String password = "IRS_dop_V1";

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey() throws NoSuchAlgorithmException {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        //AES 要求密钥长度为 128
        kg.init(128, random);
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        // 转换为AES专用密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }

    /**
     * AES加密
     *
     * @param content 需要加密的字符串
     * @return 返回Base64转码后的加密数据
     * @throws Exception
     */
    public static String encryptOld(String content) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        byte[] byteContent = content.getBytes("utf-8");
        // 初始化为加密模式的密码器
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
        // 加密
        byte[] result = cipher.doFinal(byteContent);
        //通过Base64转码返回
        return Base64.encodeBase64String(result);
    }

    /**
     * AES解密
     *
     * @param encrypted 已加密的密文
     * @return 返回解密后的数据
     * @throws Exception
     */
    public static String decryptOld(String encrypted) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
        //执行操作
        byte[] result = cipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(result, "utf-8");
    }

    /**
     * 将二进制转换成16进制
     *
     * @return
     */
    public static String encrypt(String content) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        byte[] byteContent = content.getBytes("utf-8");
        // 初始化为加密模式的密码器
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
        // 加密
        byte[] buf = cipher.doFinal(byteContent);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param encrypted
     * @return
     */
    public static String decrypt(String encrypted) throws Exception {
        if (encrypted.length() < 1) {
            return null;
        }
        byte[] result = new byte[encrypted.length() / 2];
        for (int i = 0; i < encrypted.length() / 2; i++) {
            int high = Integer.parseInt(encrypted.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(encrypted.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
        //执行操作
        byte[] res = cipher.doFinal(result);
        return new String(res, "utf-8");
    }


    public static void main(String[] args) throws Exception {
        String a = "OBg1munnLYO2EkEb";
        String b = encryptOld(a);
        String c = decryptOld(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println();
        String aa = "OBg1munnLYO2EkEb";
        String bb = encrypt(aa);
        String cc = decrypt(bb);
        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
    }

}
