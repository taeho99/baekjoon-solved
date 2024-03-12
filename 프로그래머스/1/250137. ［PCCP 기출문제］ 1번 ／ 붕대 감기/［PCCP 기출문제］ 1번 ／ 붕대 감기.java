class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int last_attack_time = attacks[attacks.length-1][0];
        int continuous = 0;
        int attack_count = 0;
        int max_health = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        for(int i=0; i<=last_attack_time; i++) {
            if(i != attacks[attack_count][0]) {
                if(health + x > max_health) {
                    health = max_health;
                } else {
                    health += x;
                }
                continuous++;
                if(continuous == t) {
                    if(health + y > max_health)
                        health = max_health;
                    else
                        health += y;
                    continuous = 0;
                }
            } else {
                health -= attacks[attack_count][1];
                if(health <= 0) {
                    return -1;
                }
                continuous = 0;
                attack_count++;
            }
        }
        return health;
    }
}