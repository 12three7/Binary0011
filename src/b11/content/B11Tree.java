package b11.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.ContentList;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

public class B11Tree implements ContentList {
	static TechTree.TechNode context = null;

	private static void extendNode (UnlockableContent parent, Runnable children) {
		context = TechTree.all.find(t -> t.content == parent);
		children.run();
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives, Runnable children) {
		TechNode node = new TechNode(context, content, requirements);
		if (objectives != null) node.objectives = objectives;

		TechNode prev = context;
		context = node;
		children.run();
		context = prev;
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives) {
		node(content, requirements, objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives) {
		node(content, content.researchRequirements(), objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements) {
		node(content, requirements, Seq.with(), () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Runnable children) {
		node(content, requirements, null, children);
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives, children);
	}

	private static void node (UnlockableContent content, Runnable children) {
		node(content, content.researchRequirements(), children);
	}

	private static void node (UnlockableContent block) {
		node(block, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives) {
		nodeProduce(content, objectives, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Runnable children) {
		nodeProduce(content, Seq.with(), children);
	}

	private static void nodeProduce (UnlockableContent content) {
		nodeProduce(content, Seq.with(), () -> {
		});
	}

	@Override
	public void load() {
		extendNode(Blocks.steamGenerator, () -> {node(B11Blocks.e0000, () -> {node(B11Blocks.e0001, () -> {node(B11Blocks.e0010, () -> {node(B11Blocks.e0011);});});});});
		extendNode(Blocks.thermalGenerator, () -> {node(B11Blocks.e0100, () -> {node(B11Blocks.e0101, () -> {node(B11Blocks.e0110, () -> {node(B11Blocks.e0111);});});});});
	}
}
