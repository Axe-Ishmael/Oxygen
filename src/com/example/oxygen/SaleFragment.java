package com.example.oxygen;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import BmobBean.InfoBean_sal;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SaleFragment extends Fragment{

	private static Drawable  drawable;
	private static Bitmap bmp;
	private static String info_text;
	private static Uri info_imaguri;
	private ListView listView;
	private MessageAdapter messageAdapter;
	private List<MessageBean> mMsgBean = new ArrayList<MessageBean>();  
	private Publish publish;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View saleLayout = inflater.inflate(R.layout.sale_layout, container,false);
		publish = (Publish)getActivity();
		listView = (ListView)saleLayout.findViewById(R.id.list_sale);
		messageAdapter = new MessageAdapter(mMsgBean, publish);
		messageAdapter.notifyDataSetChanged();
		listView.setAdapter(messageAdapter);
		
		return saleLayout;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		BmobQuery<InfoBean_sal > query = new BmobQuery<InfoBean_sal>();
		query.findObjects(new FindListener<InfoBean_sal>() {
			
			@Override
			public void done(List<InfoBean_sal> arg0, BmobException arg1) {
				// TODO Auto-generated method stub
			if( arg1 == null){
				for(InfoBean_sal info : arg0){
					
					info_text = info.getInfo();
					//info_imaguri = info.getUri();
					info_imaguri = Uri.parse(info.getUri());
					Log.d("URL",info_imaguri.toString());
					Log.d("Bitmap",info_imaguri.toString());
					mMsgBean.add(new MessageBean(info_imaguri, info_text, "", ""));
				}
				
			}
			}
			
		});
		
	}
	
	
	public Bitmap downloadImag(String uri)
	{
		RequestQueue mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
		ImageRequest imageRequest = new ImageRequest(  
		        uri,  
		        new Response.Listener<Bitmap>() {  
		            @Override  
		            public void onResponse(Bitmap response) {  
		                //imageView.setImageBitmap(response);  
		            	bmp = response; 
		            
		            }  
		        }, 0, 0, Config.RGB_565, new Response.ErrorListener() {  
		            @Override  
		            public void onErrorResponse(VolleyError error) {  
		               Log.d("DownLoad",error.toString());  
		               bmp = null;
		            }  
		        });
	     		drawable =new BitmapDrawable(bmp);
		return bmp;
		
	}
	
	
}
