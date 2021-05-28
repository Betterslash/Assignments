import controller.Controller;
import controller.PersonController;
import lombok.Data;
import model.PersonParser;

import javax.swing.*;

@Data
public class MainView {
    private final Controller controller;

    private JTextArea fieldsArea;
    private JButton actionButton;
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField ageField;
    private JButton seePersonsButton;


    public void refreshList(){
        var insideRepresentation = this.controller
                .getService()
                .getRepository()
                .getRepresentation();
        fieldsArea.setText("");
        insideRepresentation.forEach(v -> fieldsArea.append(v.toString() + "\n"));
    }

    public MainView(){
        this.controller = new PersonController();
        seePersonsButton.addActionListener(e -> {
            var insideRepresentation = this.controller.getPersonsByAge();
            fieldsArea.setText("");
            insideRepresentation.forEach(v -> fieldsArea.append(v.toString() + "\n"));
        });
        actionButton.addActionListener(e -> {
            try {
                var person = PersonParser.parse(nameField.getText(), ageField.getText());
                nameField.setText("");
                ageField.setText("");
                this.controller.addPerson(person);
                refreshList();
            } catch (RuntimeException ex){
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        var frame = new JFrame("Test app!!");
        frame.setContentPane(new MainView().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
