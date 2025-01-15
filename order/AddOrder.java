package order;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddOrder extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField money;
    private JComboBox<String> casual;
    private JComboBox<String> allright;
    private JComboBox<String> dontknow;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddOrder frame = new AddOrder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddOrder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 標題
        JLabel lblNewLabel = new JLabel("等下要吃啥");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 50));
        lblNewLabel.setBounds(237, 10, 270, 60);
        contentPane.add(lblNewLabel);

        // 商品選項
        JLabel lblNewLabel_1 = new JLabel("隨便 100:");
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel_1.setBounds(78, 177, 91, 32);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("我都行 80:");
        lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(78, 135, 113, 32);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("不知道 90:");
        lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(78, 89, 113, 32);
        contentPane.add(lblNewLabel_1_2);

        // 商品數量選擇
        dontknow = new JComboBox<>();
        dontknow.setBounds(181, 95, 113, 23);
        for (int i = 0; i <= 10; i++) {
            dontknow.addItem(Integer.toString(i));
        }
        contentPane.add(dontknow);

        allright = new JComboBox<>();
        allright.setBounds(181, 141, 113, 23);
        for (int i = 0; i <= 10; i++) {
            allright.addItem(Integer.toString(i));
        }
        contentPane.add(allright);

        casual = new JComboBox<>();
        casual.setBounds(181, 183, 113, 23);
        for (int i = 0; i <= 10; i++) {
            casual.addItem(Integer.toString(i));
        }
        contentPane.add(casual);

        // 顯示訂單
        JTextArea change = new JTextArea();
        change.setFont(new Font("Monospaced", Font.BOLD, 25));
        change.setBounds(358, 187, 386, 278);
        contentPane.add(change);

        // 顯示支付金額
        JTextArea pay = new JTextArea();
        pay.setFont(new Font("Monospaced", Font.BOLD, 25));
        pay.setBounds(80, 283, 214, 179);
        contentPane.add(pay);

        // 加入購物車按鈕
        JButton btnNewButton = new JButton("加入購物車");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 計算訂單總金額
                String Casual = (String) casual.getSelectedItem();
                String Allright = (String) allright.getSelectedItem();
                String Dontknow = (String) dontknow.getSelectedItem();

                int C = Integer.parseInt(Casual);
                int A = Integer.parseInt(Allright);
                int D = Integer.parseInt(Dontknow);

                Order o = new Order(C, A, D);

                // 顯示訂單總金額
                pay.setText("隨便:" + o.getCasual() + "\n我都行:" + o.getAllright() + "\n不知道:" + o.getDontknow() + "\n總金額:" + o.getSum());
            }
        });
        btnNewButton.setBounds(181, 235, 113, 23);
        contentPane.add(btnNewButton);

        // 支付金額輸入框
        money = new JTextField();
        money.setBounds(459, 142, 137, 25);
        contentPane.add(money);
        money.setColumns(10);

        // 結帳按鈕
        JButton payButton = new JButton("結帳");
        payButton.setBounds(659, 144, 87, 23);
        payButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // 取得支付金額
                    int payment = Integer.parseInt(money.getText());
                    // 取得訂單總金額
                    int orderTotal = 0;
                    String orderText = pay.getText();
                    if (orderText.contains("總金額:")) {
                        orderTotal = Integer.parseInt(orderText.split("總金額:")[1].trim());
                    }

                    // 檢查支付金額是否足夠
                    if (payment >= orderTotal) {
                        int changeAmount = payment - orderTotal;
                        String changeText = calculateChange(changeAmount);
                        change.setText(changeText);
                    } else {
                        change.setText("金額不足，無法結帳");
                    }
                } catch (NumberFormatException ex) {
                    change.setText("請輸入有效的支付金額");
                }
            }
        });
        contentPane.add(payButton);

        JLabel lblNewLabel_1_3_1 = new JLabel("滿五百打九折");
        lblNewLabel_1_3_1.setForeground(Color.RED);
        lblNewLabel_1_3_1.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel_1_3_1.setBounds(358, 80, 137, 32);
        contentPane.add(lblNewLabel_1_3_1);

        JButton btnNewButton_5 = new JButton("清除");
        btnNewButton_5.setBounds(82, 235, 87, 23);
        btnNewButton_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                casual.setSelectedIndex(0);
                allright.setSelectedIndex(0);
                dontknow.setSelectedIndex(0);
                money.setText("");
                pay.setText("");
                change.setText(""); 
            }
        });
        contentPane.add(btnNewButton_5);
        
        JButton btnNewButton_1 = new JButton("離開");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        btnNewButton_1.setBounds(657, 478, 87, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("登出");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();Login l = new Login();
				l.setVisible(true);
        	}
        });
        btnNewButton_2.setBounds(687, 10, 87, 23);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("支付金額:");
        lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel_1_3.setBounds(358, 135, 91, 32);
        contentPane.add(lblNewLabel_1_3);
        
        JButton print = new JButton("列印");
        print.setBounds(358, 478, 87, 23);
        contentPane.add(print);
    }

    // 計算並返回找零金額（以各種面額顯示）
    private String calculateChange(int changeAmount) {
        int[] denominations = {1000, 500, 100, 10, 5, 1};
        StringBuilder changeText = new StringBuilder("找零: " + changeAmount + " 元\n");

        for (int denomination : denominations) {
            int count = changeAmount / denomination;
            if (count > 0) {
                changeText.append(denomination).append(" 元: ").append(count).append(" 張\n");
            }
            changeAmount %= denomination;
        }
        return changeText.toString();
    }
}

