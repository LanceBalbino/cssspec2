import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


   
public class Calculator extends JPanel implements ActionListener {
    
    private static final long serialVersionID = 1L;
    
    public static final int WIDTH = 320;
    public static final int HEIGHT = 480;
    
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    
    private JButton[]  numButtons;//number buttons
    private JButton[]  optButtons;//operation buttons
    private JTextField field;
    
    private double num1, num2, ans;
    private int op;//operation
    
    //0 = grid x, 1 = grid y, 2 = gridwidth, 3 = gridheight
    private int[][] numConstraints = new int[][]{
        {0, 5, 2, 1},
        {0, 4, 1, 1},
        {1, 4, 1, 1},
        {2, 4, 1, 1},
        {0, 3, 1, 1},
        {1, 3, 1, 1},
        {2, 3, 1, 1},
        {0, 2, 1, 1},
        {1, 2, 1, 1},
        {2, 2, 1, 1},  
        
        
    };
        private int[][] optConstraints = new int [][]{
            {2, 5, 1, 1},
            {3, 4, 1, 2},
            {3, 3, 1, 1},
            {3, 2, 1, 1},
            {3, 1, 1, 1},
            {2, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1},
};
    
    public Calculator(){
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        layout = new GridBagLayout();
        layout.columnWidths = new int[] {80,80,80,80};
        layout.rowHeights = new int[] {60,60,60,60,60};
        setLayout(layout);
        
        gbc = new GridBagConstraints();
        
        numButtons = new JButton[10];
            
        for(int i = 0; i <numButtons.length; i++){
            numButtons[i] = new JButton(" "+i);
        numButtons[i].addActionListener(this);
            
            
        gbc.gridx = numConstraints[i][0];
        gbc.gridy = numConstraints[i][1];
        gbc.gridwidth = numConstraints[i][2];
        gbc.gridheight = numConstraints[i][3];
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 2, 2, 2);//padding
        
        add(numButtons[i], gbc);
        
        
        }
        
        optButtons = new JButton[8];
        optButtons[0] = new JButton(".");
        optButtons[1] = new JButton("=");
        optButtons[2] = new JButton("+");
        optButtons[3] = new JButton("-");
        optButtons[4] = new JButton("X");
        optButtons[5] = new JButton("/");
        optButtons[6] = new JButton("+/-");
        optButtons[7] = new JButton("CLR");
        for(int i = 0; i < optButtons.length; i++){
        gbc.gridx = optConstraints[i][0];
        gbc.gridy = optConstraints[i][1];
        gbc.gridwidth = optConstraints[i][2];
        gbc.gridheight = optConstraints[i][3];
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2,2,2,2);//padding
        
        optButtons[i].addActionListener(this);
        add(optButtons[i], gbc);
        }
        
        /*gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(numButtons[0],gbc);*/
        field = new JTextField();
        field.setBorder(BorderFactory.createLineBorder(Color.black));
        field.setEditable(false);
        /*field.setFont(new Font("Arial", font.PLAIN, 24));*/
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        
        add(field, gbc);
    }
   
    public static void main(String[] args) {
        
     JFrame frame = new JFrame("Calculator");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setResizable(false);
     frame.setLayout(new BorderLayout());
     frame.add(new Calculator(), BorderLayout.CENTER);
     frame.pack();
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
     
    }

    
    public void actionPerformed(ActionEvent e) {
    for(int i = 0; i < numButtons.length; i++){
    if (e.getSource() == numButtons[i]){
        field.setText(field.getText() + i);
    }
    }
    
    if (e.getSource() == optButtons[0] &&  field.getText().contains(".")){
    field.setText(field.getText()+ ",");
            
    }
    if (e.getSource() == optButtons[6]){
    field.setText(""+(-1*Double.parseDouble(field.getText())));
    }
    if (e.getSource() == optButtons[7]){
    field.setText("");
    }
    if (e.getSource() == optButtons[2]){
    num1 = Double.parseDouble(field.getText());
    op= 1;
    field.setText("");
    }
    if (e.getSource() == optButtons[3]){
    num1 = Double.parseDouble(field.getText());
    op= 2;
    field.setText("");
    }
    if (e.getSource() == optButtons[4]){
    num1 = Double.parseDouble(field.getText());
    op= 3;
    field.setText("");
    }
    if (e.getSource() == optButtons[5]){
    num1 = Double.parseDouble(field.getText());
    op= 4;
    field.setText("");
    }
    if (e.getSource() == optButtons[1]){
    num2 = Integer.parseInt(field.getText());
    
    if(op == 1  ){
    ans = num1 + num2;  
    }else if (op == 2){
    ans = num1 - num2;  
    }else if (op == 3){
    ans = num1 * num2;  
    }else if (op == 4){
        ans = num1 / num2;  
    }
    op = 0;
    field.setText("" + ans);
    
    }
    }
    
}

