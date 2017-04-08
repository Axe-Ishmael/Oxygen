package com.king.photo.activity;

import java.io.File;

import BmobBean.InfoBean;
import BmobBean.InfoBean_sal;
import BmobBean.InfoBean_stu;
import BmobBean.MyUser;
import Tools.PathGetter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;



import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

import com.example.oxygen.Publish;
import com.example.oxygen.R;
import com.king.photo.util.Bimp;
import com.king.photo.util.FileUtils;
import com.king.photo.util.ImageItem;
import com.king.photo.util.PublicWay;
import com.king.photo.util.Res;


/**
 * 发布页面activity
 */
public class Fabu extends Activity  {

	private MyUser userinfo ;
	private final int REQUEST_CODE_PICK_IMAGE = 1;
	private static Uri uri;
	private Button send;
	private EditText info_ed;
	private static String info_text;
	private static String occupation;
	
	private GridView noScrollgridview;
	private GridAdapter adapter;
	private View parentView;
	private PopupWindow pop = null;
	private LinearLayout ll_popup;
	public static Bitmap bimap ;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Res.init(this);
		bimap = BitmapFactory.decodeResource(
				getResources(),
				R.drawable.icon_addpic_unfocused);
		PublicWay.activityList.add(this);
		parentView = getLayoutInflater().inflate(R.layout.fabu_selecting, null);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(parentView);
		Init();
	}

	public void Init() {
		
		pop = new PopupWindow(Fabu.this);
		
		View view = getLayoutInflater().inflate(R.layout.item_popupwindows, null);

		ll_popup = (LinearLayout) view.findViewById(R.id.ll_popup);
		
		pop.setWidth(LayoutParams.MATCH_PARENT);
		pop.setHeight(LayoutParams.WRAP_CONTENT);
		pop.setBackgroundDrawable(new BitmapDrawable());
		pop.setFocusable(true);
		pop.setOutsideTouchable(true);
		pop.setContentView(view);
		
		RelativeLayout parent = (RelativeLayout) view.findViewById(R.id.parent);
		Button bt1 = (Button) view
				.findViewById(R.id.item_popupwindows_camera);
		Button bt2 = (Button) view
				.findViewById(R.id.item_popupwindows_Photo);
		Button bt3 = (Button) view
				.findViewById(R.id.item_popupwindows_cancel);
		send = (Button)findViewById(R.id.activity_selectimg_send);
		send.setBackgroundColor(Color.parseColor("#000000"));
		info_ed = (EditText)findViewById(R.id.info_ed);
		//info_text = info_ed.getText().toString();
		
		
		userinfo = BmobUser.getCurrentUser(MyUser.class);
		occupation = (String)BmobUser.getObjectByKey("occupation");
		parent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				photo();
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				/*
				Intent intent = new Intent(Fabu.this,
						AlbumActivity.class);
				startActivity(intent);
				*/
				getImageFromAlbum();
				overridePendingTransition(R.anim.activity_translate_in, R.anim.activity_translate_out);
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pop.dismiss();
				ll_popup.clearAnimation();
			}
		});
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*
				// TODO Auto-generated method stub
				File file  =  new File(PathGetter.getPath(Fabu.this, uri));
				Log.d("FileName",file.toString());
				info_text = info_ed.getText().toString();
				String info = info_text;
				final InfoBean infoBean = new InfoBean();
				//infoBean.setInfo(info);
				Toast.makeText(Fabu.this, info, 800).show();
				final BmobFile bmobFile = new BmobFile(file);
				infoBean.setPicPath(bmobFile);
				bmobFile.upload(new UploadFileListener() {
					
					@Override
					public void done(BmobException arg0) {
						// TODO Auto-generated method stub
						if(arg0 == null){
						String info = info_text;
						String  uri = bmobFile.getFileUrl();
						infoBean.setUri(uri);
						infoBean.setInfo(info);
						infoBean.save(new SaveListener<String>() {
							
							@Override
							public void done(String arg0, BmobException arg1) {
								// TODO Auto-generated method stub
								if(arg1 == null){
									Toast.makeText(Fabu.this, "上传成功", 800).show();
									Intent intent = new Intent(Fabu.this,Publish.class);
									startActivity(intent);
									finish();
								}else{
									Toast.makeText(Fabu.this, "上传失败", 800).show();
									Log.d("SendActivity",arg1.toString());
								}
							}
						});
						}else{
							Log.d("SendFile",arg0.toString());
						}
						
					}
				});
				*/
				if(occupation.equals("学生")){
					// TODO Auto-generated method stub
					File file  =  new File(PathGetter.getPath(Fabu.this, uri));
					Log.d("FileName",file.toString());
					info_text = info_ed.getText().toString();
					String info = info_text;
					final InfoBean_stu infoBean_stu = new InfoBean_stu();
					//infoBean.setInfo(info);
					Toast.makeText(Fabu.this, info, 800).show();
					final BmobFile bmobFile = new BmobFile(file);
					infoBean_stu.setPicPath(bmobFile);
					bmobFile.upload(new UploadFileListener() {
						
						@Override
						public void done(BmobException arg0) {
							// TODO Auto-generated method stub
							if(arg0 == null){
							String info = info_text;
							String  uri = bmobFile.getFileUrl();
							infoBean_stu.setUri(uri);
							infoBean_stu.setInfo(info);
							infoBean_stu.save(new SaveListener<String>() {
								
								@Override
								public void done(String arg0, BmobException arg1) {
									// TODO Auto-generated method stub
									if(arg1 == null){
										Toast.makeText(Fabu.this, "上传成功", 800).show();
										noScrollgridview.setAdapter(null);
										Intent intent = new Intent(Fabu.this,Publish.class);
										startActivity(intent);
										finish();
									}else{
										Toast.makeText(Fabu.this, "上传失败", 800).show();
										Log.d("SendActivity",arg1.toString());
									}
								}
							});
							}else{
								Log.d("SendFile",arg0.toString());
							}
							
						}
					});
				}else if(occupation.equals("商家")){
					// TODO Auto-generated method stub
					File file  =  new File(PathGetter.getPath(Fabu.this, uri));
					Log.d("FileName",file.toString());
					info_text = info_ed.getText().toString();
					String info = info_text;
					final InfoBean_sal infoBean_sal = new InfoBean_sal();
					//infoBean.setInfo(info);
					Toast.makeText(Fabu.this, info, 800).show();
					final BmobFile bmobFile = new BmobFile(file);
					infoBean_sal.setPicPath(bmobFile);
					bmobFile.upload(new UploadFileListener() {
						
						@Override
						public void done(BmobException arg0) {
							// TODO Auto-generated method stub
							if(arg0 == null){
							String info = info_text;
							String  uri = bmobFile.getFileUrl();
							infoBean_sal.setUri(uri);
							infoBean_sal.setInfo(info);
							infoBean_sal.save(new SaveListener<String>() {
								
								@Override
								public void done(String arg0, BmobException arg1) {
									// TODO Auto-generated method stub
									if(arg1 == null){
										Toast.makeText(Fabu.this, "上传成功", 800).show();
										noScrollgridview.setAdapter(null);
										Intent intent = new Intent(Fabu.this,Publish.class);
										startActivity(intent);
										finish();
									}else{
										Toast.makeText(Fabu.this, "上传失败", 800).show();
										Log.d("SendActivity",arg1.toString());
									}
								}
							});
							}else{
								Log.d("SendFile",arg0.toString());
							}
							
						}
					});
				}
				
			}
		}
			);
		
		noScrollgridview = (GridView) findViewById(R.id.noScrollgridview);	
		noScrollgridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter = new GridAdapter(this);
		adapter.update();
		noScrollgridview.setAdapter(adapter);
		noScrollgridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == Bimp.tempSelectBitmap.size()) {
					Log.i("ddddddd", "----------");
					ll_popup.startAnimation(AnimationUtils.loadAnimation(Fabu.this,R.anim.activity_translate_in));
					pop.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
				} else {
					
				}
			}
		});

	}

	@SuppressLint("HandlerLeak")
	public class GridAdapter extends BaseAdapter {
		private LayoutInflater inflater;
		private int selectedPosition = -1;
		private boolean shape;

		public boolean isShape() {
			return shape;
		}

		public void setShape(boolean shape) {
			this.shape = shape;
		}

		public GridAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public void update() {
			loading();
		}

		public int getCount() {
			if(Bimp.tempSelectBitmap.size() == 9){
				return 9;
			}
			return (Bimp.tempSelectBitmap.size() + 1);
		}

		public Object getItem(int arg0) {
			return null;
		}

		public long getItemId(int arg0) {
			return 0;
		}

		public void setSelectedPosition(int position) {
			selectedPosition = position;
		}

		public int getSelectedPosition() {
			return selectedPosition;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_published_grida,
						parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_grida_image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			if (position ==Bimp.tempSelectBitmap.size()) {
				holder.image.setImageBitmap(BitmapFactory.decodeResource(
						getResources(), R.drawable.icon_addpic_unfocused));
				if (position == 9) {
					holder.image.setVisibility(View.GONE);
				}
			} else {
				holder.image.setImageBitmap(Bimp.tempSelectBitmap.get(position).getBitmap());
			}

			return convertView;
		}

		public class ViewHolder {
			public ImageView image;
		}

		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					adapter.notifyDataSetChanged();
					break;
				}
				super.handleMessage(msg);
			}
		};

		public void loading() {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						if (Bimp.max == Bimp.tempSelectBitmap.size()) {
							Message message = new Message();
							message.what = 1;
							handler.sendMessage(message);
							break;
						} else {
							Bimp.max += 1;
							Message message = new Message();
							message.what = 1;
							handler.sendMessage(message);
						}
					}
				}
			}).start();
		}
	}

	public String getString(String s) {
		String path = null;
		if (s == null)
			return "";
		for (int i = s.length() - 1; i > 0; i++) {
			s.charAt(i);
		}
		return path;
	}

	protected void onRestart() {
		adapter.update();
		super.onRestart();
	}

	private static final int TAKE_PICTURE = 0x000001;

	public void photo() {
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(openCameraIntent, TAKE_PICTURE);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	
		
		if (resultCode != RESULT_OK) {

			   Log.e("TAG->onresult", "ActivityResult resultCode error");

			   return;

			  }
		
		else if (requestCode == REQUEST_CODE_PICK_IMAGE) {             
           uri = data.getData();  
           Bitmap  bmp = null;
           if (uri != null){
        	   bmp = getBitmapFromUri(uri);
           } 
             //to do find the path of pic  
            ImageItem takePhoto = new ImageItem();
			takePhoto.setBitmap(bmp);
			Bimp.tempSelectBitmap.add(takePhoto);
         
     }   else if(requestCode == TAKE_PICTURE)
     {
    	 if (Bimp.tempSelectBitmap.size() < 9 && resultCode == RESULT_OK) {
				 uri =data.getData(); 
				//Log.d("TAGGGGGG",uri.toString());
				String fileName = String.valueOf(System.currentTimeMillis());
				Bitmap bm = (Bitmap) data.getExtras().get("data");
				FileUtils.saveBitmap(bm, fileName);
				
				ImageItem takePhoto = new ImageItem();
				takePhoto.setBitmap(bm);
				Bimp.tempSelectBitmap.add(takePhoto);
     }
     }
		
		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			for(int i=0;i<PublicWay.activityList.size();i++){
				if (null != PublicWay.activityList.get(i)) {
					PublicWay.activityList.get(i).finish();
				}
			}
			//noScrollgridview.setAdapter(null);
			//PublicWay.activityList.clear();
			//Intent intent  = new Intent(this,Publish.class) ;
            //startActivity(intent);
			//finish();
		}
		return true;
	}
	
	   /**
     * 判断SDK Level 选择不同的打开相册的方式
     */
    protected void getImageFromAlbum() {  
      
        
        boolean isKitKatO = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        Intent getAlbum;
        
        if (isKitKatO) {
         getAlbum = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        } else {
         getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
        }
        
        getAlbum.setType("image/*");

        startActivityForResult(getAlbum, REQUEST_CODE_PICK_IMAGE);

    }  	
	
	/*
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {  //捕获物理按键BACK的点击事件，转到Publish界面
        if(keyCode == KeyEvent.KEYCODE_BACK){
                Intent intent  = new Intent(this,Publish.class) ;
                startActivity(intent);
                finish();
          
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
	*/
    
    
    /**
     * 将URI转化为相应的Bitmap
     */
    private Bitmap getBitmapFromUri(Uri uri)
    {
    	
     try
     {
      // 读取uri所在的图片
      Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
      return bitmap;
     }
     catch (Exception e)
     {
      Log.e("[Android]", e.getMessage());
      Log.e("[Android]", "目录为：" + uri);
      e.printStackTrace();
      return null;
     }
    }
    
   


}

