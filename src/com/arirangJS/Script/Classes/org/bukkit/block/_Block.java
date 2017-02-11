package com.arirangJS.Script.Classes.org.bukkit.block;

import com.arirangJS.Script.Classes.org.bukkit._World;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSConstructor;
import org.mozilla.javascript.annotations.JSFunction;

@SuppressWarnings("unused")
public class _Block extends ScriptableObject {

	private static final long serialVersionUID = 8753978229315472270L;

	private Block block;
	
	@Override
	public String getClassName() {
		return "Block";
	}
	
	@JSConstructor
	public _Block() {}
	
	@JSConstructor
	public _Block(_World world, int x, int y, int z) {
		this.block = world.world.getBlockAt(x, y, z);
	}
	
	public _Block(Block block) {
		this.block = block;
	}
	
	@JSFunction
	public boolean breakNaturally() {
		return block.breakNaturally();
	}
	
	/* TODO: boolean breakNaturally(ItemStack tool)
	 * No ItemStack Class
	 */
	
	@JSFunction
	public int getBiome() {
		return block.getBiome().ordinal();
	}
	
	@JSFunction
	public int getBlockPower() {
		return block.getBlockPower();
	}
	
	@JSFunction
	public int getBlockPower2(int face) {
		return block.getBlockPower(BlockFace.values()[face]);
	}
	
	/* TODO: Chunk getChunk()
	 * No Chunk Class
	 */
	
	/* TODO: Collection<ItemStack> getDrops()
	 * TODO: Collection<ItemStack> getDrops(ItemStack tool)
	 * No ItemStack Class
	 */
	
	@JSFunction
	public double getHumidity() {
		return block.getHumidity();
	}
	
	@JSFunction
	public int getLightFromBlocks() {
		return block.getLightFromBlocks();
	}
	
	@JSFunction
	public int getLightFromSky() {
		return block.getLightFromSky();
	}
	
	@JSFunction
	public int getLightLevel() {
		return block.getLightFromSky();
	}
	
	@JSFunction
	public double[] getLocation() {
		Location loc = block.getLocation();
		double[] result = {loc.getX(), loc.getY(), loc.getZ()};
		return result;
	}
	
	@JSFunction
	public _Block getRelative(int face) {
		return new _Block(block.getRelative(BlockFace.values()[face]));
	}
	
	@JSFunction
	public _Block getRelative2(int face, int distance) {
		return new _Block(block.getRelative(BlockFace.values()[face], distance));
	}
	
	@JSFunction
	public _Block getRelative3(int modX, int modY, int modZ) {
		return new _Block(block.getRelative(modX, modY, modZ));
	}
	
	/* TODO: BlockState getState()
	 * No BlockState Class
	 */
	
	@JSFunction
	public double getTemperature() {
		return block.getTemperature();
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public int getTypeId() {
		return block.getTypeId();
	}
	
	@JSFunction
	public _World getWorld() {
		return new _World(block.getWorld());
	}
	
	@JSFunction
	public int getX() {
		return block.getX();
	}
	
	@JSFunction
	public int getY() {
		return block.getY();
	}
	
	@JSFunction
	public int getZ() {
		return block.getZ();
	}
	
	@JSFunction
	public boolean isBlockFaceIndirectlyPowered(int face) {
		return block.isBlockFaceIndirectlyPowered(BlockFace.values()[face]);
	}
	
	@JSFunction
	public boolean isBlockFacePowered(int face) {
		return block.isBlockFacePowered(BlockFace.values()[face]);
	}
	
	@JSFunction
	public boolean isBlockIndirectlyPowered() {
		return block.isBlockIndirectlyPowered();
	}
	
	@JSFunction
	public boolean isBlockPowered() {
		return block.isBlockPowered();
	}
	
	@JSFunction
	public boolean isEmpty() {
		return block.isEmpty();
	}
	
	@JSFunction
	public boolean isLiquid() {
		return block.isLiquid();
	}
	
	@JSFunction
	public void setBiome(int biome) {
		block.setBiome(Biome.values()[biome]);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void setData(int data) {
		block.setData((byte) data);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public void setData2(int data, boolean applyPhysics) {
		block.setData((byte) data, applyPhysics);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean setTypeId(int type) {
		return block.setTypeId(type);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean setTypeId2(int type, boolean applyPhysics) {
		return block.setTypeId(type, applyPhysics);
	}
	
	@SuppressWarnings("deprecation")
	@JSFunction
	public boolean setTypeIdAndData(int type, int data, boolean applyPhysics) {
		return block.setTypeIdAndData(type, (byte) data, applyPhysics);
	}

    public static enum _Biome {
        OCEAN,
        PLAINS,
        DESERT,
        EXTREME_HILLS,
        FOREST,
        TAIGA,
        SWAMPLAND,
        RIVER,
        HELL,
        SKY,
        FROZEN_OCEAN,
        FROZEN_RIVER,
        ICE_FLATS,
        ICE_MOUNTAINS,
        MUSHROOM_ISLAND,
        MUSHROOM_ISLAND_SHORE,
        BEACHES,
        DESERT_HILLS,
        FOREST_HILLS,
        TAIGA_HILLS,
        SMALLER_EXTREME_HILLS,
        JUNGLE,
        JUNGLE_HILLS,
        JUNGLE_EDGE,
        DEEP_OCEAN,
        STONE_BEACH,
        COLD_BEACH,
        BIRCH_FOREST,
        BIRCH_FOREST_HILLS,
        ROOFED_FOREST,
        TAIGA_COLD,
        TAIGA_COLD_HILLS,
        REDWOOD_TAIGA,
        REDWOOD_TAIGA_HILLS,
        EXTREME_HILLS_WITH_TREES,
        SAVANNA,
        SAVANNA_ROCK,
        MESA,
        MESA_ROCK,
        MESA_CLEAR_ROCK,
        VOID,
        MUTATED_PLAINS,
        MUTATED_DESERT,
        MUTATED_EXTREME_HILLS,
        MUTATED_FOREST,
        MUTATED_TAIGA,
        MUTATED_SWAMPLAND,
        MUTATED_ICE_FLATS,
        MUTATED_JUNGLE,
        MUTATED_JUNGLE_EDGE,
        MUTATED_BIRCH_FOREST,
        MUTATED_BIRCH_FOREST_HILLS,
        MUTATED_ROOFED_FOREST,
        MUTATED_TAIGA_COLD,
        MUTATED_REDWOOD_TAIGA,
        MUTATED_REDWOOD_TAIGA_HILLS,
        MUTATED_EXTREME_HILLS_WITH_TREES,
        MUTATED_SAVANNA,
        MUTATED_SAVANNA_ROCK,
        MUTATED_MESA,
        MUTATED_MESA_ROCK,
        MUTATED_MESA_CLEAR_ROCK;
    }
}
