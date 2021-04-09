package gui;

import java.util.ArrayList;
import java.util.Random;

import List.AllyUnitList;
import UnitBase.AllyUnit;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ChooseMerPanel extends VBox {

	public static int count = 0;
	private Label label;
	private boolean[] mark;
	private ArrayList<AllyUnit> allUnits;
	private MercenaryPanel panel;
	
	public ChooseMerPanel() {
		this.setPadding(new Insets(10));
		this.setSpacing(10);
		this.setAlignment(Pos.CENTER);
		
		label = new Label("Choose your mercenary (" + (count+1) + "/3)");
		label.setFont(new Font(48));
		
		allUnits = new ArrayList<AllyUnit>();
		for (AllyUnit unit : AllyUnitList.getAllUnit())
			allUnits.add(unit);
		mark = new boolean[allUnits.size()];
		ArrayList<AllyUnit> RandomUnit = new ArrayList<AllyUnit>();
		RandomUnit = getRandomUnit(mark, allUnits);
		
		panel = new MercenaryPanel(RandomUnit);
		this.getChildren().addAll(label,panel);

	}
	
	public void chooseNext() {
		this.getChildren().remove(panel);
		ArrayList<AllyUnit> RandomUnit = new ArrayList<AllyUnit>();
		RandomUnit = getRandomUnit(mark, allUnits);
		
		panel = new MercenaryPanel(RandomUnit);
		this.getChildren().add(panel);
	}
	
	public void setLabelText() {
		label.setText("Choose your mercenary (" + (count+1) + "/3)");
	}

	public static ArrayList<AllyUnit> getRandomUnit(boolean[] mark, ArrayList<AllyUnit> allUnits) {
		Random ran = new Random();
		int size = allUnits.size();
		ArrayList<AllyUnit> units = new ArrayList<AllyUnit>();
		for (int i = 0; i < 3; i++) {
			int idx;
			while (true) {
				idx = ran.nextInt(size);
				if (!mark[idx])
					break;
			}
			mark[idx] = true;
			units.add(allUnits.get(idx));
		}
		return units;
	}

}
