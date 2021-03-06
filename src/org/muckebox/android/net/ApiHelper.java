/*   
 * Copyright 2013 Karsten Patzwaldt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.muckebox.android.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.muckebox.android.utils.Preferences;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;

public class ApiHelper {
	private static final String LOG_TAG = "ApiHelper";
	
	public static String callApi(String query, String id, String[] keys, String[] values)
	    throws IOException, JSONException, AuthenticationException {
		String str_url = getApiUrl(query, id, keys, values);
		
		Log.i(LOG_TAG, "Connecting to " + str_url);
		
        MuckeboxHttpClient httpClient = new MuckeboxHttpClient();
        HttpGet httpGet = null;
       
        try {
            httpGet = new HttpGet(str_url);
            
            HttpResponse httpResponse = httpClient.execute(httpGet);
            
            return getResponseAsString(httpResponse);
		} finally {
		    if (httpGet != null)
		        httpGet.abort();
		    
		    if (httpClient != null)
		        httpClient.destroy();
		}
	}
	
    public static JSONArray callApiForArray(String query, String id, String[] keys, String[] values)
        throws AuthenticationException, JSONException, IOException {
        return new JSONArray(callApi(query, id, keys, values));
    }
	
	public static JSONArray callApiForArray(String query, String id)
	    throws IOException, JSONException, AuthenticationException
	{
		return callApiForArray(query, id, null, null);
	}
	
	public static JSONArray callApiForArray(String query)
	    throws IOException, JSONException, AuthenticationException
	{
		return callApiForArray(query, null, null, null);
	}
	
	public static JSONObject callApiForObject(String query)
	    throws AuthenticationException, JSONException, IOException {
	    return new JSONObject(callApi(query, null, null, null));
	}
	
	@SuppressLint("DefaultLocale")
	public static String getApiUrl(String query, String extra,
			String[] keys, String[] values) throws IOException {
	    String serverAddress = Preferences.getServerAddress();
	    
	    if (serverAddress == null || serverAddress.length() == 0)
	        throw new IOException("Empty server");
	    
		Uri.Builder builder = Uri.parse(
				String.format("http%s://%s:%d",
				    Preferences.getSSLEnabled() ? "s" : "",
				    Preferences.getServerAddress(),
					Preferences.getServerPort())).buildUpon();
		
		builder.path(String.format("/api/%s", query));
		
		if (extra != null)
			builder.appendPath(extra);
		
		if ((keys != null) && (values != null) && (keys.length > 0))
		{
			if (keys.length != values.length)
				throw new IOException();
			
			for (int i = 0; i < keys.length; ++i)
			{
				builder.appendQueryParameter(keys[i], values[i]);
			}
		}
		
		return builder.build().toString();
	}
	
	public static String getResponseAsString(HttpResponse response) throws IOException, AuthenticationException {
        StatusLine statusLine = response.getStatusLine();
        
        Log.d(LOG_TAG, "HTTP Response " + statusLine.getStatusCode() +
            " " + statusLine.getReasonPhrase());
        
        switch (statusLine.getStatusCode()) {
        case 401:
            throw new AuthenticationException(statusLine.getReasonPhrase());
        case 200:
            break;
        default:
            throw new IOException();
        }
        
        BufferedReader reader = new BufferedReader(
        		new InputStreamReader(
        		    response.getEntity().getContent(), "UTF-8"));
        StringBuilder str = new StringBuilder();
        char[] charBuf = new char[1024];
        
        int bytes_read;
        
        while ((bytes_read = reader.read(charBuf)) != -1)
        	str.append(charBuf, 0, bytes_read);
        
        return str.toString();
	}
}
