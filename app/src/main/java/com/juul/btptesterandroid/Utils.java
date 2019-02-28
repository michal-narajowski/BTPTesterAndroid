package com.juul.btptesterandroid;

public class Utils {

    static void setBit(byte[] data, int bit)
    {
        int byteIdx = (bit / 8);

        data[byteIdx] = setBit(data[byteIdx], bit % 8);
    }

    static byte testBit(final byte[] data, int bit)
    {
        int byteIdx = (bit / 8);

        return testBit(data[byteIdx], bit % 8);
    }

    static void clearBit(final byte[] data, int bit)
    {
        int byteIdx = (bit / 8);

        data[byteIdx] = clearBit(data[byteIdx], bit % 8);
    }

    static byte setBit(byte b, int bit) {
       return b |= 1 << bit;
    }

    static byte testBit(byte b, int bit) {
        return (byte) (b & 1 << bit);
    }

    static byte clearBit(byte b, int bit) {
        return (byte) (b & ~(1 << bit));
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }

        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void reverseBytes(byte[] bytes) {
        for(int i = 0; i < bytes.length / 2; i++)
        {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = temp;
        }
    }

    public static byte[] btAddrToBytes(String address) {
        String addrStr = address.replaceAll(":", "");
        byte[] addr = hexStringToByteArray(addrStr);
        reverseBytes(addr);
        return addr;
    }
}
