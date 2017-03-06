package com.example.oxygen;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SaleFragment extends Fragment{

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
		listView.setAdapter(messageAdapter);
		return saleLayout;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mMsgBean.add(new MessageBean (R.drawable.pure001,"有机蔬菜","",""));
		mMsgBean.add(new MessageBean (R.drawable.pure002,"佳乐文具","",""));
		mMsgBean.add(new MessageBean (R.drawable.pure003,"蒙多机械","",""));
	}
	
	
}
