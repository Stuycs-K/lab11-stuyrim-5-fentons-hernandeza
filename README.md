[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim


## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.
|elim quote is just a legacy feature|
| Support  | Example Controls |
| ------------- | ------------- |
|Support with just a number now supports the enemy (some supports are debuffs though only for the boss which makes this very slightly redundant, but maybe you want to heal the enemy), a support command with the word party in it now supports your allies and a support command with no number now supports the charachter who called it| | support Enemy (s 0), support ally (s party 0), support self (s)|:white_check_mark  
## Adventurer Subclasses

| Characteristic  | CodeWarrior |
| ------------- | ------------- |
|Only one major change|
| Base Health  | 10 - 14  | :white_check_mark



| Characteristic  | Cyborg |
| ------------- | ------------- |
| Base Health  | 8 - 12  | :white_check_mark
| Passive Healing | 2 HP | :white_check_mark
| Base Special  | Laser Charge  | :white_check_mark
| Primary Attack  | Bionically enhanced punch: 3 - 5 damage  | :white_check_mark
| Support  | Buffs teams damage by x1.5  | :white_check_mark
| Special Attack  | 9 - 10 damage distribited amongst enemies of choice  | :ballot_box_with_check :beetle (only prints message on the last one, shows damage after the last one procs and the last prompt overwrites the border a little bit though it quickly gets reset, but it def works| 

| Characteristic  | Tech Priest |
| ------------- | ------------- |
| Base Health  | 8 - 12  |    :white_check_mark
| Base Special  | Mech Mana  |  :white_check_mark
| Primary Attack  | Debuff enemies with x2/3 damage for a turn, deaks 1 persistant damage for rest of game  |  :ballot_box_with_check :beetle (only prints message on the last one, shows damage after the last one procs and the last prompt overwrites the border a little bit though it quickly gets reset, but it def works|
| Support Self  | Heals 4 - 8  | :white_check_mark
| Special Attack  | Makes one enemy sleep for 2 - 4 turns | :ballot_box_with_check :beetle (only prints message on the last one, shows damage after the last one procs and the last prompt overwrites the border a little bit though it quickly gets reset, but it def works|
| Support Team  | Heals 3 - 7  |:white_check_mark

| Characteristic  | Techno Lich (Boss) |
| ------------- | ------------- |
| Base Health  | 40 - 48  | :white_check_mark
| Base Special  | Necromancy Points  | :white_check_mark
| Primary Attack  | Laser Burst: 4 - 6 damage, +2 Necromancy Points  | :white_check_mark
| Special bar passive | If an enemy dies, necromancy points are instantly filled| :white_check_mark
| Debuff Action  | Sleep: 1 - 3 turns  | :ballot_box_with_check :beetle (only prints message on the last one, shows damage after the last one procs and the last prompt overwrites the border a little bit though it quickly gets reset, but it def works|
| Support Self  | Clears status effects  | 
| Special Attack  | Insta-kill character under 8 HP, 6 Points req |
