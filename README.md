[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Key
:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Features

:ballot_box_with_check: Sleep status condition, managed by editing sleep count and checking if the adventurer can move in Game.java.

:ballot_box_with_check: Bleed persistant damage, made by triggerBleed in adventurer/bleedCount and utilized via techpriest attacks function.

:ballot_box_with_check: Attack tick and attack multiplier, the reason for both existing was to make attack tick being negative an easier thing to manage.

:ballot_box_with_check: Distributable damage from a single turn through the cyborg special attack.

:ballot_box_with_check: Clearing of all status conditions in the lich support.

:ballot_box_with_check: Power word kill being unique to TechnoLich and dealing true damage, which is essentially just removing attack multiplier.

:ballot_box_with_check: Cool border, made by an edited draw border function.

:ballot_box_with_check: Random name generator made via dictionary of names.

| Support  | Example Controls |
| ------------- | ------------- |
|Support with just a number now supports the enemy (some supports are debuffs though only for the boss which makes this very slightly redundant, but maybe you want to heal the enemy), a support command with the word party in it now supports your allies and a support command with no number now supports the charachter who called it| | support Enemy (s 0), support ally (s party 0), support self (s) ✅  |
## Adventurer Subclasses

| Characteristic  | CodeWarrior |
| ------------- | ------------- |
|Only one major change|
| Base Health  | 10 - 14   ✅ |



| Characteristic  | Cyborg |
| ------------- | ------------- |
| Base Health  | 8 - 12   ✅ | 
| Passive Healing | 2 HP ✅ | 
| Base Special  | Laser Charge ✅  | 
| Primary Attack  | Bionically enhanced punch: 3 - 5 damage ✅ | 
| Support  | Buffs teams damage by x1.5  ✅ | 
| Special Attack  | 9 - 10 damage distribited amongst enemies of choice  ☑️ 🪲 (only prints message on the last one, shows damage after the last one procs and the last prompt overwrites the border a little bit though it quickly gets reset, but it works| | 

| Characteristic  | Tech Priest |
| ------------- | ------------- |
| Base Health  | 8 - 12  ✅|    
| Base Special  | Mech Mana  ✅|  
| Primary Attack  | Debuff enemies with x2/3 damage for a turn, deaks 1 persistant damage for rest of game    ☑️ |
| Support Self  | Heals 4 - 8  ✅| 
| Special Attack  | Makes one enemy sleep for 2 - 4 turns  ✅ |
| Support Team  | Heals 3 - 7  ✅|

| Characteristic  | Techno Lich (Boss) |
| ------------- | ------------- |
| Base Health  | 40 - 48  ✅| 
| Base Special  | Necromancy Points  ✅|
| Primary Attack  | Laser Burst: 4 - 6 damage, +2 Necromancy Points  ✅| 
| Special bar passive | If an enemy dies, necromancy points are instantly filled ✅| 
| Debuff Action  | Sleep: 1 - 3 turns   ☑️ (sleep is a new feature) | 
| Support Self  | Clears status effects  ✅| 
| Special Attack  | Insta-kill character under 8 HP, 6 Points req  ✅|
