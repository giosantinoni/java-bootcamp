package audioplayer.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import audioplayer.exceptions.MusicPlayerException;
import audioplayer.model.MusicPlayer;

public class MainFrame extends JFrame {
	private MusicPlayer musicPlayer;
	int n;

	private JPanel contentPane;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnPause;
	private JPanel panel;
	private JList listSongs;
	private JLabel lblPath;
	private JTextField txtPath;
	private JButton btnSelect;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("MusicPlayer");
		initComponents();

		musicPlayer = MusicPlayer.getInstance();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(null, "Controls", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panel.setBounds(12, 275, 426, 67);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);

		this.btnPlay = new JButton("Play");
		this.btnPlay.setBounds(12, 28, 91, 25);
		this.panel.add(this.btnPlay);

		this.btnStop = new JButton("Stop");
		this.btnStop.setBounds(115, 28, 91, 25);
		this.panel.add(this.btnStop);

		this.btnPause = new JButton("Pause");
		this.btnPause.setBounds(218, 28, 91, 25);
		this.panel.add(this.btnPause);

		this.lblPath = new JLabel("Path:");
		this.lblPath.setBounds(12, 13, 45, 15);
		this.contentPane.add(this.lblPath);

		this.txtPath = new JTextField();
		this.txtPath.setEditable(false);
		this.txtPath.setBounds(64, 11, 265, 19);
		this.contentPane.add(this.txtPath);
		this.txtPath.setColumns(10);

		this.btnSelect = new JButton("Select");
		this.btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSelect_actionPerformed(e);
			}
		});
		this.btnSelect.setBounds(341, 8, 95, 25);
		this.contentPane.add(this.btnSelect);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(17, 43, 421, 220);
		this.contentPane.add(this.scrollPane);

		this.listSongs = new JList();
		this.scrollPane.setViewportView(this.listSongs);
		this.listSongs.setVisibleRowCount(200);
		this.listSongs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.listSongs.setBorder(new TitledBorder(null, "Songs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPause_actionPerformed(e);
			}
		});
		this.btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnStop_actionPerformed(e);
			}
		});
		this.btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPlay_actionPerformed(e);
			}
		});
	}

	protected void do_btnPlay_actionPerformed(ActionEvent e) {
		try {
			if (musicPlayer.getPlayerStatus() != MusicPlayer.PAUSED) {
				musicPlayer.newPlayer(listSongs.getSelectedValue().toString());
				musicPlayer.play();
			} else
				musicPlayer.resume();
		} catch (MusicPlayerException ex) {
			showErrorMessage(ex.getMessage());
		} catch (NullPointerException ex) {
			showErrorMessage("You must select a song from the list.");
		}
	}

	protected void do_btnStop_actionPerformed(ActionEvent e) {
		musicPlayer.stop();
		n = 1;
	}

	protected void do_btnPause_actionPerformed(ActionEvent e) {
		musicPlayer.pause();
	}

	protected void do_btnSelect_actionPerformed(ActionEvent e) {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnVal = fc.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedDir = fc.getSelectedFile();
			musicPlayer.setDir(selectedDir);
			updateUI();
		}
	}

	private void updateList() {
		String[] songs = musicPlayer.getSongs();

		DefaultListModel model = new DefaultListModel();

		for (int x = 0; x < songs.length; x++)
			model.addElement(songs[x]);

		listSongs.setModel(model);
	}

	private void updateUI() {
		txtPath.setText(musicPlayer.getDir().toString());
		updateList();
	}

	private void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg, "", JOptionPane.ERROR_MESSAGE);
	}
}
