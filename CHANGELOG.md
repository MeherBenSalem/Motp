## Changelog [1.6.2]
- Fixed an issue where item locking incorrectly applied to components sharing the same starting name as the tool
- Fixed an issue that caused some configs to generate with extra space inside of them.


## Changelog [1.6.1]
- Fixed a bug where the display overlay option wasn't hiding the VP bar.  
- Fixed a bug that caused "DEBUG" messages to appear when holding a locked item.  
- Removed unused VP parameters from `drop_rate_config.toml`.  

## Changelog [1.6.0]
- Added option to toggle item locking
- Added option to enable and disable items requirements tool tips
- The item locking system now works with armors
- Added custom dimensions support to set the VP drop values
  
## Changelog [1.6.0a] (BETA)

- **Removed Content:**  
  - Experience Enhancer Artifact & all related recipes  
  - Auto Consumer Item & all related recipes  
  - All Orb Drops (XP is now gained directly from killing mobs)  
  - Config option `enable_drops`  
  - Settings in `DropRateConfig` related to orb drop chances  
  - Settings in `mainconfig` related to orb XP value  

- **Fixes & Optimizations:**  
  - Fixed MOTP keybinds category name (now called "Memory of the Past")  
  - Optimized a lot of code, improving performance by ~40%  

- **New Features & Changes:**  
  - Added `dimension_xp_modifier` setting to adjust XP gain based on mob health and dimension multiplier  
  - XP System has been **renamed to Valor Points (VP)** for better distinction from vanilla XP  
  - New **action bar message** to display XP gained from killing mobs  
  - Added `show_vp_in_action_bar` setting to toggle XP visibility in the action bar  
  - **New UI Bar** to show XP progress and percentage  

## Changelog [1.5.1]

- Added param in attributeGUI.toml to disable the stats attribute screen
- Changed debug messages in configurations

## Changelog [1.5.0]

- **Locked Items Tooltip:** Now renders at the bottom instead.  
- **Artifact Tooltips:** Removed printed required tooltips from artifacts
- **Block Placement Restriction:** Added support to deny placing blocks
- **Custom Messages:** Each individual action on locked items now has a custom message.  
- **XP Option:** Added an option to give `vanilla_xp` when `enable_drops` is off.  
- **Community Feedback:** Your feedback is crucial! Please vote this will shape the future of the mod
  - 🗳️ **Vote here:** [Vote Now](https://forms.gle/XGSRBML4LW7gAY5x6)  
- **Renamed Features:**
  - `random rewards` → `random events` (New format: `[level]LEVEL[levelEnd]CMD_TO_EXC_AT_THAT_LEVEL`)  
  - `levelup_rewards.toml` → `levelup_events.toml`
- **New Feature:** Added `on_level_event`, which executes separately when leveling an attribute
