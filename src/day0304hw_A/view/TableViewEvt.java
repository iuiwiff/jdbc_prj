package day0304.homework.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import day0304.homework.dao.TableDAO;

public class TableViewEvt extends WindowAdapter implements ActionListener, ListSelectionListener {
    private TableView tableView;

    public TableViewEvt(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action listener : " + e.getSource());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> currentList = (JList<String>) e.getSource();
        System.out.println("selection listener : " + e.getSource() + "  // " + currentList.getSelectedValue());
        TableDAO tDAO = TableDAO.getInstance();
        try {
            System.out.println(tDAO.selectAllData(currentList.getSelectedValue()));
            tableView.getJTextArea().setText(tDAO.selectAllData(currentList.getSelectedValue()));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
