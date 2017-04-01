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
		mMsgBean.add(new MessageBean (R.drawable.shetuan1,"校书法社将于16日图书馆报告厅举办一年一度的书法比赛，现诚招赞助商，要求赞助方能提供毛笔，宣纸，墨水等书法用品，最好能准备参赛者奖品。届时来参加和观看的人数众多，是一个绝好的宣传机会，我们也将提供人力支持。有意者联系QQ：45661526","",""));
		mMsgBean.add(new MessageBean (R.drawable.shetuan2,"飞翔轮滑社将于24日下午在主楼广场举办社员聚会活动，现诚招赞助者，要求能提供轮滑护具，滑轮润滑剂等专业装备，我们能提供场地以及人力支持。参加活动的每一位社员都是热情的轮滑爱好者，也是赞助商潜在的客户，如长期合作，我们将考虑将产品作为指定用品","",""));
		mMsgBean.add(new MessageBean (R.drawable.shetuan3,"电子竞技社计划在四月举办第七届电子竞技大赛，竞赛项目包含当下热门游戏，参与者众多，现诚邀网吧赞助商，要求能提供场地使用优惠以及饮料供应服务，有长期合作意向者，本社将考虑将贵网吧作为训练基地。有意者联系QQ：11569752","",""));
		mMsgBean.add(new MessageBean(R.drawable.shetuan4,"唯趣咖啡社计划举行一次新成员见面会，现诚招赞助咖啡馆，要求能提供安静温馨的场所和各种专业制作咖啡的设备以供演示，最好能有专业咖啡师提供介绍，有长期合作意向者，我社将会将贵店作为聚会大本营，利润丰厚，机不可失。有意者联系QQ:98325471","",""));
	}
}
