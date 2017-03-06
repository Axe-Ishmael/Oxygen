package com.example.oxygen;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class StudentFragment extends Fragment{

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
		mMsgBean.add(new MessageBean (R.drawable.pure001,"发布","",""));
		mMsgBean.add(new MessageBean (R.drawable.pure002,"会展","",""));
		mMsgBean.add(new MessageBean (R.drawable.pure003,"报告会","",""));
	}
}
