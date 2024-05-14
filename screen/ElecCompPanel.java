package screen;

import model.ElectricalComponent.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;
import javax.swing.border.Border;

public abstract class ElecCompPanel extends JPanel{
	private static final long serialVersionUID = 1L;
    private Menu menu;
    private int id;
    private String type;
	private JLabel nameLabel;
	private JButton removeButton;
	private JTextField inputTf;
	private JComboBox<String> unitComboBox;

	public ElecCompPanel(Menu menu, int id) {
		this.menu = menu;
        this.id = id;
        this.setLayout(null);

		nameLabel = new JLabel();

        JButton removeButton = new JButton(new RemoveIcon());
        removeButton.setPreferredSize(new Dimension(RemoveIcon.icon_size, RemoveIcon.icon_size));
        removeButton.setBorderPainted(false);
        removeButton.setContentAreaFilled(false);
        removeButton.setFocusPainted(false);
        removeButton.setOpaque(false);
        removeButton.setBorder(new RemoveIcon.RoundedBorder(15));

		inputTf = new JTextField();
		unitComboBox = new JComboBox<String>();

		nameLabel.setBounds(60, 5, 30, 15);
		add(nameLabel);

		inputTf.setBounds(50, 22, 160, 25);
		add(inputTf);

		removeButton.setBounds(15, 25, 15, 15);
                removeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rmButtonActionPerformed(e);
                    }
                });
		add(removeButton);

		unitComboBox.setBounds(250, 22, 80, 23);
		add(unitComboBox);

	}

    public void rmButtonActionPerformed(ActionEvent e) {
        menu.getElecPanels().remove(id - 1);
        menu.remove(this);
        menu.refresh();
    }

    class RemoveIcon implements Icon {
        static final int icon_size = 15;
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            int d = Math.min(icon_size, icon_size - 4); //d is diameter
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.RED);
            g2.fill(new Ellipse2D.Double(3, 3, d, d));
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(3));
            int lineLength = d - 15;
            int lineStart = (d - lineLength) / 2;
            g2.draw(new Line2D.Double(3 + lineStart, d / 2 + 3, 3 + lineStart + lineLength, d / 2 + 3));
            g2.dispose();
        }
        static class RoundedBorder implements Border {
            private int radius;

            RoundedBorder(int radius) {
                this.radius = radius;
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }
        }
        @Override
        public int getIconWidth() {
            return icon_size;
        }

        @Override
        public int getIconHeight() {
            return icon_size;
        }
    }

    public int getId() {
        return id;
    }

    public String getType(){
        return this.type;
    }

    public double getResistance(){
        return Double.parseDouble(inputTf.getText());
    }

    public JComboBox<String> getComboBox(){
        return unitComboBox;
    }

    public String getUnit(){
        return (String) unitComboBox.getSelectedItem();
    }
    
	public void setRemoveEvent(ActionListener al) {
        removeButton.addActionListener(al);
	}
    
    public void setName() {
        nameLabel.setText(this.type + Integer.toString(id));
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type){
        this.type = type;
    }
    
    public abstract void setUnit();
    public abstract ElectricalComponent castToElecComp();
    
}
