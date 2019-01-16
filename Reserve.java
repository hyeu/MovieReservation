import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.*;
import java.util.Calendar;
import java.util.*;



public class Reserve extends JDialog implements ListSelectionListener, ActionListener, Runnable{
    //JFrame frame;
	//JDialog dialog;
    private Thread thread;
    private JLabel currenttimeL;
    private JList movieList;
    private JList theaterList;
    private JList timeList;
    private JButton nextbtn;
    private JButton prevbtn;
    private JRadioButton typebtn3;
    private JRadioButton typebtn1;
    private JRadioButton typebtn5;
    private JRadioButton typebtn2;
    private JRadioButton typebtn4;
    private JRadioButton typebtn6;
    private JComboBox dateC;
    private JPanel typeP;
    private JPanel titleP;
    private JScrollPane timeSP;
    private JPanel timeP;
    private JScrollPane theaterSP;
    private JPanel theaterP;
    private JScrollPane movieSP;
    private JPanel movieP;
    private JPanel mainP, mainP2;
    private JLabel movieL;
    private JLabel theaterL;
    private JLabel timeL;
    private JLabel titleL;
    private JPanel dateP;
    private JPanel listP;
    private JPanel btnP;
	public JPanel checkP;
	public JLabel checkL;
    private String[] movieArray = {"주먹왕 랄프2: 인터넷 속으로", "말모이", "내안의 그놈","아쿠아맨", "그린북","보헤미안 랩소디", "스파이더맨 뉴 유니버스","범블비"};
    private String[] theaterArray = {"강남","코엑스","신촌"};
	public Vector ralphGangnamtimeVect;
	public Vector ralphCoextimeVect;
	public Vector ralphShintimeVect;
    private String[] ralphGangnamtimeArray = {"10:05 8관","11:40 2관","12:30 3관","13:30 2관"};
    private String[] ralphCoextimeArray = {"10:25 2관", "11:45 컴포트 8관", "14:00 9관"};
    private String[] ralphShintimeArray = {"11:00 4관", "11:20 2관", "12:50 10관"};
    private String[] dateArray = {"2019.01.15", "2019.01.16", "2019.01.17", "2019.01.18"};
	public String[] nullArray = {};

    public Reserve(){

		ralphGangnamtimeVect = new Vector();
		ralphGangnamtimeVect.add("10:05 8관");
		ralphGangnamtimeVect.add("11:40 2관");
		ralphGangnamtimeVect.add("12:30 3관");
		ralphGangnamtimeVect.add("13:30 2관");

		ralphCoextimeVect = new Vector();
		ralphCoextimeVect.add("10:25 2관");
		ralphCoextimeVect.add("11:45 컴포트 8관");
		ralphCoextimeVect.add("14:00 9관");

		ralphShintimeVect = new Vector();
		ralphShintimeVect.add("11:00 4관");
		ralphShintimeVect.add("11:20 2관");
		ralphShintimeVect.add("12:50 10관");

        //frame = new JFrame("영화 예매");

        mainP = new JPanel();
        mainP.setLayout(new GridLayout(4,1));
        mainP2 = new JPanel();
        mainP2.setLayout(new GridLayout (3,1));

        titleL = new JLabel("MOVIE RESERVATION");
        titleL.setFont(new Font("Dialog",Font.BOLD, 25));
        titleL.setForeground(Color.darkGray);
        titleL.setHorizontalAlignment(JLabel.CENTER);
        mainP2.add(titleL);

        dateC = new JComboBox<String>(dateArray);
        dateC.setAlignmentX(Component.CENTER_ALIGNMENT);
        currenttimeL = new JLabel();
        currenttimeL.setFont(new Font("Dialog", Font.BOLD, 15));
        currenttimeL.setHorizontalAlignment(JLabel.CENTER);
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
        mainP2.add(currenttimeL);
        mainP2.add(dateC);

        listP = new JPanel();
        listP.setLayout(new GridLayout(1,3));

        movieP = new JPanel();
        movieP.setLayout(new GridLayout(2,1));
        movieP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"영화 선택", TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,0,0)));

        movieSP = new JScrollPane(movieList);
        movieList = new JList<String>(movieArray);
        movieList.setVisibleRowCount(10);
        movieList.setFixedCellHeight(50);
        movieList.setFixedCellWidth(10);

        movieP.add(new JScrollPane(movieList));

        theaterP = new JPanel();
        theaterP.setLayout(new GridLayout(2,1));
        theaterP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"상영관 선택", TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,0,0)));

        theaterList = new JList<String>(theaterArray);
        theaterList.setVisibleRowCount(10);
        theaterList.setFixedCellHeight(50);
        theaterList.setFixedCellWidth(10);
        theaterP.add(new JScrollPane(theaterList));

		theaterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		theaterList.addListSelectionListener(this);


        timeP = new JPanel();
        timeP.setLayout(new GridLayout(2,1));
        timeP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"시간 선택", TitledBorder.LEADING,TitledBorder.TOP,null,new Color(0,0,0)));

        timeList = new JList<String>(ralphGangnamtimeArray);
        timeList.setVisibleRowCount(10);
        timeList.setFixedCellHeight(50);
        timeList.setFixedCellWidth(10);
        timeList.setSize(300,300);

        timeP.add(new JScrollPane(timeList));

        listP.add(movieP);
        listP.add(theaterP);
        listP.add(timeP);

        btnP = new JPanel();

        nextbtn = new JButton("확인");
		nextbtn.addActionListener(this);

        //btnP.add(prevbtn);
        btnP.add(nextbtn);

		checkP = new JPanel();
		checkL = new JLabel(" ");
		checkP.add(checkL);

        mainP.add(mainP2);
        mainP.add(listP);
        mainP.add(btnP);
		mainP.add(checkP);
        this.add(mainP);

		this.setSize(900, 900);
		this.setLocation(500,90);
		this.setModal(true);
        this.setVisible(true); 

    }
    public void run(){
        while(true){
            Calendar cal = Calendar.getInstance();
            String current = cal.get(Calendar.YEAR) + "." + (cal.get(Calendar.MONTH)+1)+ "." + cal.get(Calendar.DATE) +  ".\n" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
            currenttimeL.setText(current);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
	
	public void valueChanged(ListSelectionEvent e){
		JList theaterList = (JList) e.getSource();
		int idx = theaterList.getSelectedIndex();
		if (idx == 0){
			timeList.setListData(ralphGangnamtimeVect);
			checkL.setText(" ");
			timeList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event1) {
					JList timeList = (JList)event1.getSource();
					int tidx1 = timeList.getSelectedIndex(); 
					if (tidx1 == 0)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[0] + " " + ralphGangnamtimeArray[tidx1]);
					}else if (tidx1 == 1)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[0] + " " + ralphGangnamtimeArray[tidx1]);
					}else if (tidx1 == 2)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[0] + " " + ralphGangnamtimeArray[tidx1]);
					} else if (tidx1 == 3)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[0] + " " + ralphGangnamtimeArray[tidx1]);
					}
				}
			});

		}else if (idx == 1){
			timeList.setListData(ralphCoextimeVect);
			checkL.setText(" ");
			timeList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event2) {
					JList timeList = (JList)event2.getSource();
					int tidx2 = timeList.getSelectedIndex(); 
					if (tidx2 == 0)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[1] + " " + ralphCoextimeArray[tidx2]);
					}else if (tidx2 == 1)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[1] + " " + ralphCoextimeArray[tidx2]);
					}else if (tidx2 == 2)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[1] + " " + ralphCoextimeArray[tidx2]);
					} 
				}
			});

		}else if (idx == 2){
			timeList.setListData(ralphShintimeVect);
			checkL.setText(" ");
			timeList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event3) {
					JList timeList = (JList)event3.getSource();
					int tidx3 = timeList.getSelectedIndex(); 
					if (tidx3 == 0)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[2] + " " + ralphShintimeArray[tidx3]);
					}else if (tidx3 == 1)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[2] + " " + ralphShintimeArray[tidx3]);
					}else if (tidx3 == 2)
					{
						checkL.setText(dateArray[0] + " " + movieArray[0] + " " + theaterArray[2] + " " + ralphShintimeArray[tidx3]);
					} 
				}
			});
		}

	}

	public void actionPerformed(ActionEvent nextE) {
		if (nextE.getSource() == nextbtn)
		{	
			this.remove(mainP);
			this.add(new SeatSelection());
			this.setSize(600,500);
			this.setVisible(true);
		}
	}

    /*public static void main(String[] args){
        new Reserve();
    }*/
}