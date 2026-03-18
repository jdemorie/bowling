import {useMemo} from "react";

const useColumnDefs = () => {
    return useMemo(
        () => [
            "Name", "Turn 1", "Turn 2", "Turn 3", "Turn 4", "Turn 5", "Turn 6", "Turn 7", "Turn 8", "Turn 9", "Turn 10", "Turn 11", "Turn 12", "Score"
        ],
        [],
    );
}

export default useColumnDefs;