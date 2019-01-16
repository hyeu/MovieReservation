import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.*;

public class SeatSelection extends JPanel implements ActionListener{
    private JScrollPane scroll;
    private JPanel title;
    private JPanel seatpanel;
    private JPanel confirmpanel;
    private JLabel titleLabel;
    private JLabel front;
    private JComboBox<String> numC;
    private JButton[][] buttons = new JButton[10][10];
    private JButton confirmbtn;
    private char[][] board = new char[10][10];
    //private char seat_selected = 'X';
    private boolean flag = true;
    private String people;
    private String[] numberofpeople = {"1", "2", "3", "4"};
    int numSeat = 0;
    String[][] seatArray = {
    {"A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09", "A10"},
    {"B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10"},
    {"C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10"},
    {"D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10"},
    {"E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09", "E10"},
    {"F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10"},
    {"G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10"},
    {"H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10"},
    {"I01", "I02", "I03", "I04", "I05", "I06", "I07", "I08", "I09", "I10"},
    {"J01", "J02", "J03", "J04", "J05", "J06", "J07", "J08", "J09", "J10"}};
    int cnt = 0;



    public SeatSelection(){

        title = new JPanel();
        title.setLayout(new GridLayout(3,1));
        titleLabel = new JLabel("좌석을 선택해주세요");
        titleLabel.setFont(new Font("맑은 고딕",Font.BOLD, 20));
        titleLabel.setForeground(Color.darkGray);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        numC = new JComboBox<String>(numberofpeople);

        //num.setBounds(10,10,10,2);
        front = new JLabel("FRONT");
        front.setHorizontalAlignment(JLabel.CENTER);

        title.add(titleLabel,BorderLayout.CENTER);
        title.add(numC,"East");
        title.add(front, BorderLayout.CENTER);


        /*numC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people = numC.getSelectedItem().toString();
                numSeat = Integer.parseInt(people);
                System.out.print(people);
            }
        });*/

        seatpanel = new JPanel();
        seatpanel.setLayout(new GridLayout(10,10,1,1));

        Font font = new Font("Dialog", Font.ITALIC, 10);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                buttons[i][j] = new JButton(seatArray[i][j]);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                seatpanel.add(buttons[i][j]);
            }
        }

       /* buttons.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent be){
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        if(be.getSource() == buttons[i][j] && buttons[i][j].getBackground(Color).equals("white")){
                            if(flag == true)
                                buttons[i][j].setBackground(Color.darkGray);
                        }
                    }
                }
            }
        });
*/
        confirmpanel = new JPanel();
        confirmbtn = new JButton("확인");
        confirmbtn.addActionListener(this);
        confirmpanel.add(confirmbtn);

        add(title);
        add(seatpanel);
        add(confirmpanel);
    }

    @Override
        public void actionPerformed(ActionEvent be){
			if (be.getSource() == confirmbtn)
			{
				JDialog d = new JDialog();
				d.add(new Confirmation());
				d.setSize(500, 700);
				d.setModal(true);
				d.setVisible(true);

			}else {
				for(int i = 0; i < 10; i++){
					for(int j = 0; j < 10; j++){
						people = numC.getSelectedItem().toString();
						numSeat = Integer.parseInt(people);
						if(be.getSource() == buttons[i][j] && buttons[i][j].getText().equals(seatArray[i][j])){
							if(cnt >= numSeat){
								JOptionPane.showMessageDialog(null, "이미 좌석을 선택하셨습니다.");
								flag = false;
							}
							else if(flag == true){
								++cnt;
								buttons[i][j].setText("selected");
							}
						}
						else if(be.getSource() == buttons[i][j] && buttons[i][j].getText().equals("selected"))
						{
							buttons[i][j].setText(seatArray[i][j]);
							cnt--;
						}
					}
				}
			}
        }

    /*public static void main(String[] args){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new SeatSelection());
        f.setSize(850, 800);
        f.setVisible(true);
    }*/
}        	