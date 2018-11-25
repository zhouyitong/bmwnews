package com.xywy.zngj.common.utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
public class ZipUtil {
	
	 private static String encode = "utf-8";//"ISO-8859-1"
	/**
	* 使用gzip进行压缩
	*/
	public static String gzip(String primStr) {
		 if (primStr == null || primStr.length() == 0) {
	            return null;
	        }
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        GZIPOutputStream gzip;
	        try {
	            gzip = new GZIPOutputStream(out);
	            gzip.write(primStr.getBytes(encode));
	            gzip.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
	}

	/**
	*
	* <p>Description:使用gzip进行解压缩</p>
	* @param compressedStr
	* @return
	*/
	public static String gunzip(String compressedStr){
		if (compressedStr == null || compressedStr.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
        	byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            ByteArrayInputStream in = new ByteArrayInputStream(compressed);
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	* 使用zip进行压缩
	* @param str 压缩前的文本
	* @return 返回压缩后的文本
	*/
	public static final String zip(String str) {
		if (str == null)
			return null;
		byte[] compressed;
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		String compressedStr = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str.getBytes());
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
		} catch (IOException e) {
			compressed = null;
		} finally {
		if (zout != null) {
			try {
			zout.close();
			} catch (IOException e) {
			}
		}
		if (out != null) {
			try {
			out.close();
			} catch (IOException e) {
			}
		}
	}
		return compressedStr;
	}

	/**
	* 使用zip进行解压缩
	* @param compressed 压缩后的文本
	* @return 解压后的字符串
	*/
	public static final String unzip(String compressedStr) {
		if (compressedStr == null) {
		return null;
		}
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
	try {
		byte[] compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
		out = new ByteArrayOutputStream();
		in = new ByteArrayInputStream(compressed);
		zin = new ZipInputStream(in);
		zin.getNextEntry();
		byte[] buffer = new byte[1024];
		int offset = -1;
		while ((offset = zin.read(buffer)) != -1) {
		out.write(buffer, 0, offset);
		}
		decompressed = out.toString();
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
				zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
				in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}
	return decompressed;
	}
}
