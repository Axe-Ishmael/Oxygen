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
		mMsgBean.add(new MessageBean (R.drawable.shangpu2,"泸沽湖民宿青年旅店。 本店希望在贵校进行旅游宣传活动，联系电话：18452256122","",""));
		mMsgBean.add(new MessageBean (R.drawable.shangpu3,"新开张傣族特色自助餐，宣传活动即将开始，现诚邀校园合作伙伴,有意者请加QQ：5449115317","",""));
		mMsgBean.add(new MessageBean (R.drawable.shangpu4,"We close英伦服饰，成都旗舰店即将营业，现诚招校园活动宣传合作伙伴，联系电话:15182220003","",""));
		mMsgBean.add(new MessageBean(R.drawable.shangpu5,"Adidas青春校园3V3篮球联赛联赛即将举行，现诚招校园活动志愿者，志愿者将会获得Adidas志愿者工作服装一套，以及志愿者证书认定","",""));
		mMsgBean.add(new MessageBean(R.drawable.shangpu6,"”Nike足球校园中国行“活动志愿者招聘正式开启,成为志愿者将会有机会与足球巨星面对面交流，并有机会抽取签名足球鞋，机会难得，期待你的加入。报名电话：1569646513.截止时间：2017/01/12","",""));
		mMsgBean.add(new MessageBean(R.drawable.shangpu8,"面魂汤商业街店开业两周年庆，将于主楼前举行现场展示美食制作活动，现诚邀校园合作团体为我们提供音响和舞台设备以及人员支持，报酬面议。联系电话:13890226659，","",""));
	}
	
	
}
