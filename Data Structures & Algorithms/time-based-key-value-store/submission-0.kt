class TimeMap() {

    val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val entry = map.getOrPut(key) {
            mutableListOf()
        }

        entry.addLast(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val entry = map[key]

        if(entry.isNullOrEmpty() || entry[0].first > timestamp) {
            return ""
        }


        var l = 0
        var r = entry.lastIndex

        while(l < r) {
            val mid = l + (r - l) / 2
            if(l == mid){
                break;
            }
            if (entry[mid].first == timestamp) {
                return entry[mid].second
            } else if (entry[mid].first < timestamp) {
                l = mid
            } else { // entry[mid].first > timeStamp
                r = mid
            }
        }
    
        if(l == r || timestamp >= entry[r].first) {
            return entry[r].second
        } else {
            return entry[l].second
        } 

    }
}
