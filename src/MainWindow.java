import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainWindow extends JFrame {
    String[][] questions = {
        {
            "1.) Melyik GUI könyvtár Java-hoz?",
            "Qt",
            "Samba",
            "Swing",
            "Kapula",
            "Swing"
        },
        {
            "2.) Melyik Java fordító utasítás",
            "cjava",
            "javac",
            "java",
            "jc",
            "javac"
        },
        {
            "3.) Melyikkel lehet feliratot készíteni?",
            "JFraem",
            "JPanel",
            "JRadioButton",
            "JLabel",
            "JLabel"
        }
    };

    JPanel panel = new JPanel();
    JLabel queestionLabel = new JLabel();
    JRadioButton[] radioButtons = new JRadioButton[4];
    ButtonGroup group = new ButtonGroup();
    JButton nextButton = new JButton("Következő");
    Integer status = -1;
    String answer = "";

    public MainWindow() {
        for(int i=0;i<4; i++) {
            radioButtons[i] = new JRadioButton();            
        }

        nextButton.addActionListener(e -> onClickNextButton());

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS) );
        panel.add(queestionLabel);
        for(int i=0; i<4; i++) {            
            panel.add(radioButtons[i]);
        }        
        panel.add(nextButton);
        
        this.add(panel);
        this.setTitle("App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    private void onClickNextButton() {

        if( this.status > -1) {
            if(this.goodQuestion()) {
                this.answer = "Jó válasz";
            }else {
                this.answer = "Rossz válasz";
            }
        }

        clearSelection();
        System.out.println(this.answer);
        if(this.status < this.questions.length -1) {
            this.status++;
        }else {
            this.status = 0;
        }
        
        this.queestionLabel.setText(questions[this.status][0]);
        for(int i=0; i<4; i++) {
            this.radioButtons[i].setText(questions[this.status][i+1]);
        }

    }

    private boolean goodQuestion() {
        boolean good = false;
        for(int i=0; i<4; i++) {
            String selected = this.radioButtons[i].getText();
            System.out.println(selected);
            System.out.println(questions[this.status][5]);
            if(this.radioButtons[i].isSelected() && 
                selected.equals(questions[this.status][5])) {
                    good = true;
            }
        }
        return good;
    }

    private void clearSelection() {
        for(int i=0; i<4; i++) {
            this.radioButtons[i].setSelected(false);
        }
    }
    
}
