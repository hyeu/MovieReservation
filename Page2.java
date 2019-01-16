import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Page2 extends JFrame implements ActionListener 

{
	JPanel p1, p2, p3, p4, p5, b1, b2, b3, b4, lj, tPanel;
	JButton i1, i2, i3, i4, r1, r2, r3, r4, login, join;
	JLabel l1, l2, l3, l4, title; 
	Info1 info1;
	Info2 info2;
	Info3 info3;
	Info4 info4;
	LoginPanel loginView;
	Reserve reserve;

	
	public Page2() {
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title = new JLabel();
		ImageIcon timage = new ImageIcon("title.PNG");
		title.setIcon(timage);

		login = new JButton("로그인");
		login.addActionListener(this);
		join = new JButton("회원가입");
		join.addActionListener(this);
		lj = new JPanel();
		lj.add(login);
		lj.add(join);

		tPanel = new JPanel();
		tPanel.setLayout(new FlowLayout());
		tPanel.add(title);
		tPanel.add(lj);


		p1 = new JPanel();
		p1.setLayout(new BorderLayout(5,5));
		l1 = new JLabel();
		ImageIcon movie1 = new ImageIcon("movie1.jpeg");
		l1.setIcon(movie1);
		i1 = new JButton("상세정보");
		i1.addActionListener(this);
		r1 = new JButton("예매하기");
		r1.addActionListener(this);
		b1 = new JPanel();
		b1.setLayout(new FlowLayout());
		b1.add(i1);
		b1.add(r1);
		p1.add("North", l1);
		p1.add("South", b1);

		p2 = new JPanel();
		p2.setLayout(new BorderLayout(5,5));
		l2 = new JLabel();
		ImageIcon movie2 = new ImageIcon("movie2.jpeg");
		l2.setIcon(movie2);
		i2 = new JButton("상세정보");
		i2.addActionListener(this);
		r2 = new JButton("예매하기");
		r2.addActionListener(this);
		b2 = new JPanel();
		b2.setLayout(new FlowLayout());
		b2.add(i2);
		b2.add(r2);
		p2.add("North", l2);
		p2.add("South", b2);

		p3 = new JPanel();
		p3.setLayout(new BorderLayout(5,5));
		l3 = new JLabel();
		ImageIcon movie3 = new ImageIcon("movie3.jpeg");
		l3.setIcon(movie3);
		i3 = new JButton("상세정보");
		i3.addActionListener(this);
		r3 = new JButton("예매하기");
		r3.addActionListener(this);
		b3 = new JPanel();
		b3.setLayout(new FlowLayout());
		b3.add(i3);
		b3.add(r3);
		p3.add("North", l3);
		p3.add("South", b3);


		p4 = new JPanel();
		p4.setLayout(new BorderLayout(5,5));
		l4 = new JLabel();
		ImageIcon movie4 = new ImageIcon("movie4.jpeg");
		l4.setIcon(movie4);
		i4 = new JButton("상세정보");
		i4.addActionListener(this);
		r4 = new JButton("예매하기");
		r4.addActionListener(this);
		b4 = new JPanel();
		b4.setLayout(new FlowLayout());
		b4.add(i4);
		b4.add(r4);
		p4.add("North", l4);
		p4.add("South", b4);


		p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);

		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.white);
		p5.setBackground(Color.white);
		b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		lj.setBackground(Color.white);
		tPanel.setBackground(Color.white);
		
		setLayout(new BorderLayout());
		add("North",tPanel);
		add("Center",p5);
		setSize(1150,900);
		setVisible(true);
	}

	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == i1 ){
			info1 = new Info1();
		}else if (e.getSource() == i2 ) {
			info2 = new Info2();
		}else if (e.getSource() == i3 ) {
			info3 = new Info3();
		}else if (e.getSource() == i4) {
			info4 = new Info4();
		} else if (e.getSource() == login) {
			loginView = new LoginPanel();
		}else {
			reserve = new Reserve();
		}
	}
}

class Info1 extends JDialog
{
	public Info1() {
		JPanel panel = new JPanel(); //전체패널
		JPanel cPanel = new JPanel(); //한줄평패널
		JLabel comment1 = new JLabel("한줄평"); //한줄평 패널
		JLabel text = new JLabel(); //줄거리 
		ImageIcon t1 = new ImageIcon("text1.PNG"); //줄거리이미지 
		text.setIcon(t1); 
		JLabel image = new JLabel(); //영화인포라벨
		ImageIcon ii = new ImageIcon("info1.PNG"); //인포이미지
		image.setIcon(ii);
		JTextArea comment = new JTextArea("한줄평을 남겨주세요",3, 55); 
		cPanel.add(comment1);
		cPanel.add(comment);
		panel.setLayout(new FlowLayout());
		panel.add(image);
		panel.add(text);
		panel.add(cPanel);

		getContentPane().add(panel);
		this.setSize(700,800);
		this.setLocation(600, 200);
		this.setModal(true);
		this.setVisible(true);
	}
}

class Info2 extends JDialog
{
	public Info2() {
		JPanel panel = new JPanel();
		JPanel cPanel = new JPanel();
		JLabel comment1 = new JLabel("한줄평");
		JLabel text = new JLabel();
		ImageIcon t1 = new ImageIcon("text2.PNG");
		text.setIcon(t1);
		JLabel image = new JLabel();
		ImageIcon ii = new ImageIcon("info2.PNG");
		image.setIcon(ii);
		JTextArea comment = new JTextArea("한줄평을 남겨주세요",3, 55); 
		cPanel.add(comment1);
		cPanel.add(comment);
		panel.setLayout(new FlowLayout());
		panel.add(image);
		panel.add(text);
		panel.add(cPanel);

		getContentPane().add(panel);
		this.setSize(700,850);
		this.setLocation(600, 150);
		this.setModal(true);
		this.setVisible(true);
	}
}

class Info3 extends JDialog
{
	public Info3() {
		JPanel panel = new JPanel();
		JPanel cPanel = new JPanel();
		JLabel comment1 = new JLabel("한줄평");
		JLabel text = new JLabel();
		ImageIcon t1 = new ImageIcon("text3.PNG");
		text.setIcon(t1);
		JLabel image = new JLabel();
		ImageIcon ii1 = new ImageIcon("info3.PNG");
		image.setIcon(ii1);
		JTextArea comment = new JTextArea("한줄평을 남겨주세요",3, 55); 
		cPanel.add(comment1);
		cPanel.add(comment);
		panel.setLayout(new FlowLayout());
		panel.add(image);
		panel.add(text);
		panel.add(cPanel);

		getContentPane().add(panel);
		this.setSize(700,850);
		this.setLocation(600, 150);
		this.setModal(true);
		this.setVisible(true);
	}
}

class Info4 extends JDialog
{
	public Info4() {
		JPanel panel = new JPanel();
		JPanel cPanel = new JPanel();
		JLabel comment1 = new JLabel("한줄평");
		JLabel text = new JLabel();
		ImageIcon t1 = new ImageIcon("text4.PNG");
		text.setIcon(t1);
		JLabel image = new JLabel();
		ImageIcon ii1 = new ImageIcon("info4.PNG");
		image.setIcon(ii1);
		JTextArea comment = new JTextArea("한줄평을 남겨주세요",3, 55); 
		cPanel.add(comment1);
		cPanel.add(comment);
		panel.setLayout(new FlowLayout());
		panel.add(image);
		panel.add(text);
		panel.add(cPanel);

		getContentPane().add(panel);
		this.setSize(700,550);
		this.setLocation(600, 200);
		this.setModal(true);
		this.setVisible(true);
	}
}

class LoginPanel extends JDialog{
	//private Main main;
    //private LoginFrame testFrm;
   
    private JButton btnLogin;
    private JButton btnInit;
    private JPasswordField passText;
    private JTextField userText;
    private boolean bLoginCheck;
	LoginPanel loginView;
   
    public static void main(String[] args) {
        new LoginPanel();
    }
 
    public LoginPanel() {
        // setting
        this.setTitle("login");
        this.setSize(280, 150);
        this.setResizable(false);
        this.setLocation(800, 450);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        // panel
        JPanel panel = new JPanel();
        placeLoginPanel(panel);
       
       
        // add
        getContentPane().add(panel);
       
        // visiible
		this.setModal(true);
        this.setVisible(true);
    }
   
    public void placeLoginPanel(JPanel panel){
        panel.setLayout(null);     
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);
       
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(10, 40, 80, 25);
        panel.add(passLabel);
       
        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);
       
        passText = new JPasswordField(20);
        passText.setBounds(100, 40, 160, 25);
        panel.add(passText);
        passText.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();        
            }
        });
       
        btnInit = new JButton("Reset");
        btnInit.setBounds(10, 80, 100, 25);
        panel.add(btnInit);
        btnInit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userText.setText("");
                passText.setText("");
            }
        });
       
        btnLogin = new JButton("Login");
        btnLogin.setBounds(160, 80, 100, 25);
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();
            }
        });
    }
   
    public void isLoginCheck(){
        if(userText.getText().equals("jang123") && new String(passText.getPassword()).equals("1234")){
            JOptionPane.showMessageDialog(null, "Success");
            bLoginCheck = true;
           
            // 로그인 성공이라면 매니져창 뛰우기
            if(isLogin()){
                showFrameTest(); // 메인창 메소드를 이용해 창뛰우기
            }                  
        }else{
            JOptionPane.showMessageDialog(null, "Failed");
        }
    }
 
   
    // mainProcess와 연동
    //public void setMain(Main main) {
        //this.main = main;
    //}
   
 
    public boolean isLogin() {     
        return bLoginCheck;
    }

	public void showFrameTest(){
        loginView.dispose(); // 로그인창닫기
        //this.testFrm = new LoginFrame(); // 테스트프레임 오픈
    }

}

