package com.heybro.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * http工具类
 *
 * @author zjm
 *
 */
public class HttpClientUtil {

	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

	private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000)
			.setConnectionRequestTimeout(15000).build();

	private static HttpClientUtil instance = null;

	private HttpClientUtil() {
	}

	public static HttpClientUtil getInstance() {
		if (instance == null) {
			instance = new HttpClientUtil();
		}
		return instance;
	}

	/**
	 * 发送 post请求
	 *
	 * @param httpUrl
	 *            地址
	 */
	public String sendHttpPost(String httpUrl) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		return sendHttpPost(httpPost);
	}

	/**
	 * 发送 post请求
	 *
	 * @param httpUrl
	 *            地址
	 * @param params
	 *            参数(格式:key1=value1&key2=value2)
	 */
	public String sendHttpPost(String httpUrl, String params) throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		// 设置参数
		StringEntity stringEntity = new StringEntity(params, "UTF-8");
		stringEntity.setContentType("application/x-www-form-urlencoded");
		httpPost.setEntity(stringEntity);
		return sendHttpPost(httpPost);
	}

	/**
	 * 发送 post请求
	 *
	 * @param httpUrl
	 *            地址
	 * @param params
	 *            参数
	 */
	public String sendHttpPost(String httpUrl, Map<String, String> params) {
		HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
		// 创建参数队列
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("send http post error:\n", e);
		}
		return sendHttpPost(httpPost);
	}

	/**
	 * 发送Post请求
	 *
	 * @param httpPost
	 * @return
	 */
	private String sendHttpPost(HttpPost httpPost) {
		logger.debug("send http post [{}]", httpPost.getURI());
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpPost.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			logger.error("send http post error:\n", e);
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("send http post error:\n", e);
			}
		}
		return responseContent;
	}

	/**
	 * 发送 get请求
	 *
	 * @param httpUrl
	 */
	public String sendHttpGet(String httpUrl) {
		HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求
		return sendHttpGet(httpGet);
	}

	/**
	 * 发送 get请求Https
	 *
	 * @param httpUrl
	 */
	public String sendHttpsGet(String httpUrl) {
		HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求
		return sendHttpsGet(httpGet);
	}

	/**
	 * 发送 get请求Https
	 *
	 * @param httpUrl
	 * @param params
	 *
	 */
	public String sendHttpsGet(String httpUrl, Map<String, String> params) {
		String result = "";
		try {
			URIBuilder uriBuilder = new URIBuilder(httpUrl);
			// 创建参数队列
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
			}
			uriBuilder.setParameters(nameValuePairs);
			HttpGet httpGet = new HttpGet(uriBuilder.build());// 创建get请求
			result = sendHttpsGet(httpGet);
		} catch (URISyntaxException e) {
			logger.error("send https get error:\n", e);
		}
		return result;
	}

	/**
	 * 发送Get请求
	 *
	 * @param httpGet
	 * @return
	 */
	private String sendHttpGet(HttpGet httpGet) {
		logger.debug("send http get [{}]", httpGet.getURI());
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpGet.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			logger.error("send http get error:\n", e);
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("send http get error:\n", e);
			}
		}
		return responseContent;
	}

	/**
	 * 发送Get请求Https
	 *
	 * @param httpGet
	 * @return
	 */
	private String sendHttpsGet(HttpGet httpGet) {
		logger.debug("send https get [{}]", httpGet.getURI());
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			try {
				PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader
						.load(new URL(httpGet.getURI().toString()));
				DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
				httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
				httpGet.setConfig(requestConfig);
				// 执行请求
				response = httpClient.execute(httpGet);
				entity = response.getEntity();
				responseContent = EntityUtils.toString(entity, "UTF-8");
			} catch (Exception e) {
				logger.error("send https get error:\n", e);
			}
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				logger.error("send https get error:\n", e);
			}
		}
		return responseContent;
	}
}