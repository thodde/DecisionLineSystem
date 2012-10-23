package DLS.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;

import DLS.model.Model;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SimpleEdge extends JPanel {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public SimpleEdge(Model m) {
		//setTitle("SimpleEdge");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		EdgeDisplayPanel edgePanel = new EdgeDisplayPanel(m);
		edgePanel.setPreferredSize(new Dimension(100,0));
		edgePanel.setBorder(BorderFactory.createLineBorder(Color.red,3));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Step");
		
		JButton btnNewButton = new JButton("Next Step");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Prev Step");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(edgePanel, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
					.addGap(21))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(289, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(edgePanel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
