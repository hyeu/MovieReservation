import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


class Confirmation extends JPanel implements ActionListener{
    private JButton btn;
    private JTextArea informT;
    private JPanel titleP;
    private JLabel titleL;
    private JLabel movieL;
    private JPanel btnP;
    private JPanel movieP;
    private JPanel informP;
    private JLabel qrL;
    private JPanel qrP;
    private JPanel mainP;
    private JPanel bodyP;
    private JLabel nameL;
    private JLabel theaterL;
    private JLabel timeL;
    private JLabel seatL;

    public Confirmation() {

        mainP = new JPanel();
        mainP.setLayout(new GridLayout(4,1));

        titleP = new JPanel();
        titleP.setLayout(new GridLayout(1,1));
        titleL = new JLabel("Confirmation");
        titleL.setFont(new Font("Dialog",Font.BOLD, 20));
        titleL.setForeground(Color.darkGray);
        titleL.setHorizontalAlignment(JLabel.CENTER);
        titleP.add(titleL);

        bodyP = new JPanel();
        bodyP.setLayout(new GridLayout(1,2));
        movieP = new JPanel();
        movieL = new JLabel();
        ImageIcon movie1 = new ImageIcon("movie_c.jpeg");
        movieL.setIcon(movie1);
        movieP.add(movieL);

        qrP = new JPanel();
        qrL = new JLabel();
        ImageIcon qr = new ImageIcon("qr.jpeg");
        qrL.setIcon(qr);
        qrP.add(qrL,BorderLayout.CENTER);

        bodyP.add(movieP);
        bodyP.add(qrP);

        informP = new JPanel();
        informP.setLayout(new GridLayout(2,2));

        theaterL = new JLabel("2019.01.15 ");
        theaterL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        theaterL.setForeground(Color.BLACK);
        theaterL.setHorizontalAlignment(JLabel.CENTER);

        nameL = new JLabel("주먹왕 랄프2: 인터넷 속으로");
        nameL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        nameL.setForeground(Color.BLACK);
        nameL.setHorizontalAlignment(JLabel.CENTER);

        timeL = new JLabel("코엑스 10:25 2관 F05, F06, F07");
        timeL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        timeL.setForeground(Color.RED);
        timeL.setHorizontalAlignment(JLabel.CENTER);


        informP.add(nameL);
        informP.add(timeL);


        btnP = new JPanel();
        btn = new JButton("확인");
		btn.addActionListener(this);
        btnP.add(btn);

        add(titleL);
        add(bodyP);
        mainP.add(theaterL);
        mainP.add(nameL);
        mainP.add(timeL);
        mainP.add(btnP);
        add(mainP);


    }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn)
		{
			//d.dispose();
		}
	}
    /*public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Confirmation());
        f.setSize(500, 700);
        f.setVisible(true);
    }*/
}