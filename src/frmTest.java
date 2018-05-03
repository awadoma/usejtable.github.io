import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmTest<DafaultTableModele> extends JFrame {
	private JTable tblEmp;
	private JTextField txtName;
	private JTextField txtSal;
	protected DefaultTableModel modele;
	protected int currentRow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTest frame = new frmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 332);
		getContentPane().setLayout(null);
		
		tblEmp = new JTable();
		tblEmp.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblEmp.setModel(new DefaultTableModel(
			new Object[][] {
				{"Name", "Salary"},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tblEmp.setBounds(22, 113, 361, 181);
		getContentPane().add(tblEmp);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(22, 11, 82, 14);
		getContentPane().add(lblEmployeeName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(32, 36, 46, 14);
		getContentPane().add(lblSalary);
		
		txtName = new JTextField();
		txtName.setBounds(114, 8, 204, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSal = new JTextField();
		txtSal.setBounds(114, 33, 204, 20);
		getContentPane().add(txtSal);
		txtSal.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			DefaultTableModel modele;
			public void setTable() {
				modele = (DefaultTableModel)tblEmp.getModel();
			}
			public void clearText() {
				txtName.setText("");
				txtSal.setText("");
				txtName.requestFocus();
			}
			public void actionPerformed(ActionEvent arg0) {
				setTable();
				modele.addRow(new Object [] {txtName.getText(),txtSal.getText()});
				clearText();
				
				
			}
		});
		btnAdd.setBounds(77, 79, 56, 23);
		getContentPane().add(btnAdd);
		
		JButton btnDelit = new JButton("Delit");
		btnDelit.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				modele = (DefaultTableModel)tblEmp.getModel();
				currentRow = tblEmp.getSelectedRow();
				modele.removeRow(currentRow);
				clearText();
			}
		});
		btnDelit.setBounds(253, 79, 65, 23);
		getContentPane().add(btnDelit);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(new ActionListener() {
			int currentRow;
			public void actionPerformed(ActionEvent e) {
				modele = (DefaultTableModel)tblEmp.getModel();
				currentRow = tblEmp.getSelectedRow();
				modele.setValueAt(txtName.getText(), currentRow, 0);
				modele.setValueAt(txtSal.getText(), currentRow, 1);
				clearText();
			}
		});
		btnUpdate.setBounds(143, 79, 89, 23);
		getContentPane().add(btnUpdate);
	}

	protected void clearText() {
		// TODO Auto-generated method stub
		
	}
}
