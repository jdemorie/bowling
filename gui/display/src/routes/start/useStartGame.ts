import {useStartMutation} from "../../openapi/enhancedApi";
import {useCallback, useState} from "react";

export const useStartGame = () => {
    const [start] = useStartMutation();
    const [isGameStart, setGameStart] = useState(false);
    const [isStartSuccess, setStartSuccess] = useState(false);

    const startGame = useCallback((name: string) => {
            setGameStart(true);
            start({
                body: [{name: name}],
            })
                .then(
                    (_) => {
                        setStartSuccess(true);
                    },
                    (reason) => {
                        setStartSuccess(false);
                    },
                )
                .finally(() => {
                    setGameStart(false);
                });
        },
        [start],
    );
    return {startGame, isStartSuccess, isGameStart};
};