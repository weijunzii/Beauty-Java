package face;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import cn.xsshome.taip.face.TAipFace;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Face {
	public void in(String args[]) { 
		JFrame jf = new JFrame();
		JLabel bg = new JLabel(new ImageIcon("..\\face\\image/3.jpg"));//创建背景
		JTextArea text=new JTextArea("       检测结果     "+"\n"+"\n");
		Icon icon=new ImageIcon("..\\face\\image/1.png");//设置按钮图片
		JButton open = new JButton("选取照片",icon);//创建按钮
		open.addActionListener(new OpenButton() {//点击按钮的事件
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("请选择图片文件...");//选择图片
				FileNameExtensionFilter filter=new FileNameExtensionFilter("常用图片格式", "jpg", "jpeg", "gif", "png");
				
				chooser.setFileFilter(filter);
				int returnVal =chooser.showOpenDialog(null);
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					String imgPath = chooser.getSelectedFile().getAbsolutePath();//图片的路径
					ImageIcon icon =new ImageIcon(imgPath);
					bg.setIcon(icon);//更新背景图片
					try {
						String res =deface(imgPath);//调用 deface 方法
						JsonParser parse =new JsonParser();
				        try {
				            JsonObject json=(JsonObject) parse.parse(res);//创建jsonObject对象
				            //将 json 数据转为为 int 型的数据
				            int gen=json.get("gender").getAsInt();
				            String gender=" 性别：男";
				            if(gen<50)
				            	gender=" 性别：女";
				            //将 json 数据转为为 String 型的数据
				            String age=json.get("age").getAsString(); //年龄
				            String beauty=json.get("beauty").getAsString(); //颜值
				            int glas=json.get("glass").getAsInt();//是否佩戴眼镜，0为没有，1为有
				            String glass="";
				            if(glas==1)
				            	glass=" 你好，戴眼镜的朋友";
				            
				            String expression="";//表情
				            int express=json.get("expression").getAsInt();
				            if(express< 10)
				            	expression="黯然伤神";
				            else if(express< 20)
				            	expression="半嗔半喜";
				            else if(express< 30)
				            	expression="似笑非笑";
				            else if(express< 40)
				            	expression="笑逐颜开";
				            else if(express< 50)
				            	expression="笑逐颜开";
				            else if(express< 60)
				            	expression="喜上眉梢";
				            else if(express< 70)
				            	expression="喜上眉梢";
				            else if(express< 80)
				            	expression="笑尽妖娆";
				            else if(express< 90)
				            	expression="心花怒放";
				            else
				            	expression="一笑倾城";
				            
				            int pitch=json.get("pitch").getAsInt();
				            int yaw=json.get("yaw").getAsInt();
				            int roll=json.get("roll").getAsInt();
				            StringBuffer posture=new StringBuffer(" 姿势：");
				            if(pitch>3)
				            	posture.append("低头");
				            if(pitch<-3)
				            	posture.append("抬头");
				            if(yaw!=0)
				            	posture.append("偏头");
				            if(roll<-3&roll>3)
				            	posture.append("侧颜杀");
				            text.setText("       检测结果     "+"\n"+"\n"+"\n");
				            text.setLineWrap(true);
				            text.append(gender+"\n"+"\n");
				            text.append(" 年龄："+age+"\n"+"\n");
				            text.append(" 颜值："+beauty+"\n"+"\n");
				            text.append(" 表情："+expression+"\n"+"\n");
				            text.append(posture+"\n"+"\n");
				            text.append(glass+"\n");
				        }catch (JsonIOException e) {
				            e.printStackTrace();
				        } catch (JsonSyntaxException e) {
				            e.printStackTrace();
				        }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		text.setFont(new Font("楷体",Font.BOLD,24));
		jf.setTitle("颜值检测");//设置标题
		jf.setSize(1000,800);//设置窗口大小
		jf.add(bg);//添加背景图
		jf.add(open,"South");//添加按钮
		jf.add(text,"East");//添加文字
		jf.setLocation(200, 150);//设置窗口位置
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//单击关闭退出程序
		jf.setVisible(true);//显示框架
	}
	class OpenButton implements ActionListener{
		public void actionPerformed(ActionEvent event) {
		}
	}
    
    public String deface(String imgPath) throws Exception{
    	final String APP_ID = "你的 APP_ID";//APP_ID
        final String APP_KEY = "你的 APP_KEY";//APP_KEY
    	TAipFace aipFace = new TAipFace(APP_ID, APP_KEY);
        
        
        String result = aipFace.detect(imgPath);//人脸检测与分析
        
        //System.out.println(result);//输出返回的数据
        JsonParser parse =new JsonParser();
        try {
            JsonObject json=(JsonObject) parse.parse(result);  //创建jsonObject对象
            //System.out.println("resultcode:"+json.get("resultcode").getAsInt());  //将 json 数据转为为 int 型的数据
            //System.out.println("reason:"+json.get("reason").getAsString());     //将 json 数据转为为 String 型的数据
             
            JsonObject data=json.get("data").getAsJsonObject();
            JsonArray face_list=data.get("face_list").getAsJsonArray();
            
            JsonObject subObject=face_list.get(0).getAsJsonObject();
            String ret=subObject.toString();
            System.out.println(ret);
            return ret;
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
		return result;
		
    }
    public static void main(String args[]) throws Exception{
    	new Face().in(args);
    }
}