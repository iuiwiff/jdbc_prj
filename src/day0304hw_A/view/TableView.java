package day0304.homework.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import day0304.homework.dao.TableDAO;

@SuppressWarnings("serial")
public class TableView extends JFrame {
    private DefaultListModel<String> tablesData;
    private JList<String> tablesList;
    private JTextArea tableInfo;

    public TableView() {
        super();
        setLayout(null);
        createTableJList();

        JScrollPane scrollPane = new JScrollPane(tablesList);
        scrollPane.setBounds(50, 50, 200, 300);
        add(scrollPane);

        tableInfo = new JTextArea();
        tableInfo.setBounds(300, 50, 600, 300);
        add(tableInfo);

        tablesList.addListSelectionListener(new TableViewEvt(this));

        setSize(1000, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextArea getJTextArea() {
        return tableInfo;
    }

    public void createTableJList() {
        TableDAO tDAO = TableDAO.getInstance();
        tablesData = new DefaultListModel<String>();

        try {
            List<String> tables = tDAO.selectAllTab();
            for (String str : tables) {
                tablesData.addElement(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tablesList = new JList<String>(tablesData);
    }

    public static void main(String[] args) {
        new TableView();
    }
}
