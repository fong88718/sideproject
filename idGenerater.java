import java.awt.*;
import java.awt.event.*;

// 實作ItemListener介面
public class hw4 extends java.awt.Frame implements ItemListener
{
    java.awt.Label label;
	int numbers[] = new int[8];
	int region = 0;
	int sex = 0;
	char R;
	java.awt.Choice choice = new Choice();

    public static void main(String args[])
    {
      new hw4();
    }
    public hw4() 
    {
		super("身分證字號產生器");
		
		GridBagLayout gridbaglayout = new GridBagLayout();
		GridBagConstraints gbConstraints = new GridBagConstraints();
		
		String[] items = {"臺北市", "台中市", "基隆市", "台南市","高雄市","新北市","宜蘭縣","桃園縣","嘉義市","新竹縣","苗栗縣","南投縣","彰化縣","新竹市","雲林縣","嘉義縣","屏東縣","花蓮縣","台東縣","金門縣","澎湖縣","連江縣"};
		String E = "ABCDEFGHIJKMNOPQTUVWXZ";
		setLayout(gridbaglayout);
		setBackground(Color.PINK);
		
		Label label1= new Label("                           ",Label.LEFT);
		label1.setFont(new Font("dialog", Font.BOLD, 20));
		label1.setForeground(Color.RED);
		
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;		
		gridbaglayout.setConstraints(label1, gbConstraints);
		this.add(label1);
		

		label = new Label("地區  ");
		label.setFont(new Font("dialog", Font.BOLD, 20));
		this.add(label);
		label.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
				label1.setText("請選擇地區...");
			}
			public void mouseExited(MouseEvent e)
			{
				label1.setText("");
			}
		});
		
		
		for (int i=0; i < items.length; i++)
			choice.add(items[i]);
		choice.setFont(new Font("dialog",Font.PLAIN, 13));
		choice.select(0);
		
		choice.addItemListener(this);
		
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;	
		gridbaglayout.setConstraints(choice, gbConstraints);	
		this.add(choice);
		choice.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
				label1.setText("請選擇地區...");
			}
			public void mouseExited(MouseEvent e)
			{
				label1.setText("");
			}
		});
		
		
		label = new Label("性別  ");
		label.setFont(new Font("dialog", Font.BOLD, 20));
		this.add(label);
		label.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
				label1.setText("請選擇性別...");
			}
			public void mouseExited(MouseEvent e)
			{
				label1.setText("");
			}
		});
		
		
		java.awt.Checkbox checkbox[] = new Checkbox[2];
		java.awt.CheckboxGroup group = new CheckboxGroup();
		checkbox[0] = new Checkbox("男", true, group);
		checkbox[1] = new Checkbox("女", false, group);
		for(int i=0 ; i < 2 ; i++)
			checkbox[i].setFont(new Font("dialog", Font.BOLD, 15));
			
		gbConstraints.gridwidth = GridBagConstraints.RELATIVE;	
		gridbaglayout.setConstraints(checkbox[1], gbConstraints);
		checkbox[0].setState(true);
		this.add(checkbox[0]);
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;	
		gridbaglayout.setConstraints(checkbox[1], gbConstraints);
		this.add(checkbox[1]);	
		
		for(int i=0 ; i < 2 ; i++)
		{
			checkbox[i].addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent e)
				{
					label1.setText("請選擇性別...");
				}
				public void mouseExited(MouseEvent e)
				{
					label1.setText("");
				}
			});
		}
		
		Label label2 = new Label("               ",Label.LEFT);
		label2.setFont(new Font("dialog", Font.BOLD, 22));
		label2.setForeground(Color.RED);
		
		Button button = new Button("產生");
		gbConstraints.fill = GridBagConstraints.HORIZONTAL;	
		gridbaglayout.setConstraints(button ,gbConstraints);
		this.add(button);
		
		button.addMouseListener(new MouseAdapter(){
				public void mouseEntered(MouseEvent e)
				{
					label1.setText("選好後再按產生!!!");
				}
				public void mouseExited(MouseEvent e)
				{
					label1.setText("");
				}
			});
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				int x=1;
				int number = 0;
				for(int i = 0 ; i < 8 ; i++)
					numbers[i] = (int)(Math.random()*8+1);

				for(int i=0;i<8;i++)
				{
					number +=  numbers[i]*x;
					x *= 10;
				}
				R = E.charAt(region);
				if(checkbox[0].getState() == true)
					sex = 1;
				else if(checkbox[1].getState() == true)
					sex = 2;
		
				label2.setText(R+""+sex+""+number+"");
			}		
		});
		
		gbConstraints.gridwidth = GridBagConstraints.REMAINDER;	
		gridbaglayout.setConstraints(label2 ,gbConstraints);
		this.add(label2);
		
		this.setSize(600, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height)
		  frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
		  frameSize.width = screenSize.width;
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent e) {
			    System.exit(0);
		    }
		});
	}	
	public void itemStateChanged(ItemEvent e)
	{
		Choice ch = (Choice)(e.getSource());
		region =  ch.getSelectedIndex();
	}
}
