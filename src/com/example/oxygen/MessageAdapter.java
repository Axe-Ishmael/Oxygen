package com.example.oxygen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageAdapter extends BaseAdapter{

	 private List<MessageBean> mListMsgBean = null;  
	    private Context mContext;  
	    private LayoutInflater mInflater;  
	    public MessageAdapter(List<MessageBean> listMsgBean, Context context){  
	        mListMsgBean = listMsgBean;  
	        mContext = context;  
	        mInflater = LayoutInflater.from(mContext);  
	    }  
	    @Override  
	    public int getCount() {  
	        // TODO Auto-generated method stub  
	        return mListMsgBean.size();  
	    }  
	  
	    @Override  
	    public Object getItem(int position) {  
	        // TODO Auto-generated method stub  
	        return mListMsgBean.get(position);  
	    }  
	  
	    @Override  
	    public long getItemId(int position) {  
	        // TODO Auto-generated method stub  
	        return position;  
	    }  
	  
	    @Override  
	    public View getView(int position, View convertView, ViewGroup parent) {  
	        // TODO Auto-generated method stub  
	        View v = mInflater.inflate(R.layout.student_list_item, null);  //��ʵstudent��sale����student_list_item
	          
	       
	        ImageView imageView = (ImageView) v.findViewById(R.id.student_pic);
	        Picasso.with(mContext).load(mListMsgBean.get(position).getPhotoDrawableId()).resize(120, 70).centerCrop().into(imageView);
	       // imageView.setImageURI(mListMsgBean.get(position).getPhotoDrawableId());  
	          
	        TextView nameMsg = (TextView)v.findViewById(R.id.student_name);  
	        nameMsg.setText(mListMsgBean.get(position).getMessageName());  
	  
	        TextView contentMsg = (TextView)v.findViewById(R.id.student_content);  
	        contentMsg.setText(mListMsgBean.get(position).getMessageContent());  
	          
	        TextView timeMsg = (TextView)v.findViewById(R.id.student_time);  
	        timeMsg.setText(mListMsgBean.get(position).getMessageTime());  
	  
	        return v;  
	    }  
	  
	}  

	

