package com.example.oxygen;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import BmobBean.InfoBean_stu;
import BmobBean.InfoBean_stu;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StudentFragment extends Fragment{

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
		View studentLayout = inflater.inflate(R.layout.student_layout,container, false);
		publish = (Publish)getActivity();
		listView = (ListView)studentLayout.findViewById(R.id.list_student);
		messageAdapter = new MessageAdapter(mMsgBean, publish);
		listView.setAdapter(messageAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				MessageBean Msgbean = mMsgBean.get(position);
				Intent intent = new Intent(getActivity(),Neirong.class);
				startActivity(intent);
			}
		});
		
		return studentLayout;
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		BmobQuery<InfoBean_stu > query = new BmobQuery<InfoBean_stu>();
		query.findObjects(new FindListener<InfoBean_stu>() {
			
			@Override
			public void done(List<InfoBean_stu> arg0, BmobException arg1) {
				// TODO Auto-generated method stub
			if( arg1 == null){
				for(InfoBean_stu info : arg0){
					
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
}
