import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private AudioPlayer player = new AudioPlayer();
	private Thread playbackThread;

	private boolean isPlaying = false;
	private boolean isPause = false;

	private String audioFilePath;

	private JButton btnOpen = new JButton("Open wav file");
	private JButton btnStop = new JButton("Stop");
	private JButton btnPlay = new JButton("Play");
	private JButton btnPause = new JButton("Pause");

	private JLabel lblFileName = new JLabel("Playing File:");

	public GUI() {
		super("Audio Player");
		setLayout(new GridBagLayout());
		getContentPane().setBackground(Color.BLACK);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.WEST;

		lblFileName.setForeground(Color.WHITE);

		btnOpen.setFont(new Font("Sans", Font.BOLD, 14));
		btnOpen.setPreferredSize(new Dimension(150, 40));

		btnStop.setFont(new Font("Sans", Font.BOLD, 14));
		btnStop.setPreferredSize(new Dimension(150, 40));
		btnStop.setEnabled(false);

		btnPlay.setFont(new Font("Sans", Font.BOLD, 14));
		btnPlay.setPreferredSize(new Dimension(150, 40));
		btnPlay.setEnabled(false);

		btnPause.setFont(new Font("Sans", Font.BOLD, 14));
		btnPause.setPreferredSize(new Dimension(150, 40));
		btnPause.setEnabled(false);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		add(lblFileName, constraints);

		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridy = 1;
		constraints.gridwidth = 1;

		constraints.gridx = 1;

		constraints.gridx = 2;

		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 5));
		panelButtons.setBackground(Color.BLACK);
		panelButtons.add(btnOpen);
		panelButtons.add(btnPlay);
		panelButtons.add(btnStop);
		panelButtons.add(btnPause);

		constraints.gridwidth = 3;
		constraints.gridx = 0;
		constraints.gridy = 2;
		add(panelButtons, constraints);

		btnOpen.addActionListener(this);
		btnStop.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);

		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source instanceof JButton) {
			JButton button = (JButton) source;
			if (button == btnOpen) {
				openFile();
			} else if (button == btnPlay) {
				playBack();
			} else if (button == btnStop) {
				stopPlaying();
			} else if (button == btnPause) {
				if (!isPause) {
					pausePlaying();
				} else {
					resumePlaying();
				}
			}
		}
	}

	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		;

		FileFilter wavFilter = new FileFilter() {
			@Override
			public String getDescription() {
				return "Sound file (*.WAV)";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};

		fileChooser.setFileFilter(wavFilter);
		fileChooser.setDialogTitle("Open Audio File");
		fileChooser.setAcceptAllFileFilterUsed(false);

		int userChoice = fileChooser.showOpenDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			audioFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (isPlaying || isPause) {
				stopPlaying();
				while (player.getAudioClip().isRunning()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
			playBack();
		}
	}

	private void playBack() {
		isPlaying = true;
		playbackThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					btnPlay.setEnabled(true);

					btnPause.setEnabled(true);

					btnStop.setEnabled(true);

					player.load(audioFilePath);
					lblFileName.setText("Playing File: " + audioFilePath);

					player.play();

					resetControls();

				} catch (UnsupportedAudioFileException ex) {
					JOptionPane.showMessageDialog(GUI.this, "Audio format not supported!", "Error", JOptionPane.ERROR_MESSAGE);
					resetControls();
					ex.printStackTrace();
				} catch (LineUnavailableException ex) {
					JOptionPane.showMessageDialog(GUI.this, "Line sound not available!", "Error", JOptionPane.ERROR_MESSAGE);
					resetControls();
					ex.printStackTrace();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(GUI.this, "I/O error!", "Error", JOptionPane.ERROR_MESSAGE);
					resetControls();
					ex.printStackTrace();
				}

			}
		});

		playbackThread.start();
	}

	private void stopPlaying() {
		isPause = false;
		btnPause.setEnabled(false);
		player.stop();
		playbackThread.interrupt();
	}

	private void pausePlaying() {
		btnPause.setText("Resume");
		isPause = true;
		player.pause();
		playbackThread.interrupt();
	}

	private void resumePlaying() {
		btnPause.setText("Pause");
		isPause = false;
		player.resume();
		playbackThread.interrupt();
	}

	private void resetControls() {
		btnPlay.setText("Play");
		btnPause.setEnabled(false);

		isPlaying = false;
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

}
