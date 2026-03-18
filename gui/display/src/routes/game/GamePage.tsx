import React, {useEffect, useMemo, useState} from "react";
import {StyledButton, Container, Gif, InputColumnContainer, StyledLabel} from "../../shared/SharedStyles";
import {useName} from "../../store/playerSlice";
import useColumnDefs from "./useColumnDefs";
import Launching from "./Launching";
import Grid from "../../shared/Grid";
import {useGetScoreQuery} from "../../openapi/enhancedApi";
import AwaitQuery from "../../shared/AwaitQuery";
import {usePlayGame} from "./usePlayGame";
import {motion} from "motion/react";

const GamePage = () => {
    const name = useName();
    const headers = useColumnDefs();
    const [isLaunching, setIsLaunching] = useState(false);
    const query = useGetScoreQuery();
    const {playGame, isPlayStart, getPinsDown} = usePlayGame();

    const data: Array<Record<string, string>> | undefined = useMemo(() => {
        return query.data?.map(scoreBean => {
            const turns = scoreBean.turns;
            const turnData: Record<string, string> = {};
            if (turns === undefined) {
                return turnData;
            }
            turnData["Name"] = scoreBean.name;
            for (let i = 0; i < turns.length; i++) {
                turnData[`Turn ${i + 1}`] = turns[i].value;
            }
            turnData["Score"] = scoreBean.score.toString();
            return turnData;
        });
    }, [query]);

    function throwBall() {
        playGame(name);
    }

    useEffect(() => {
        if (isPlayStart) {
            setIsLaunching(true);
        } else {
            setIsLaunching(false);
        }
    }, [isPlayStart]);

    return (
        <AwaitQuery query={query}>
            <motion.div style={{cursor: isLaunching ? "wait" : "default"}}>
                {isLaunching ? (
                    <Launching/>
                ) : (
                    <Container>
                        <Gif src="/pins.jpg" alt="Bowling GIF"/>
                        <InputColumnContainer>
                            <h2 style={{color: "white"}}>Bowling score</h2>
                            <Grid headers={headers} data={data} testId="grid"/>
                            <StyledButton onClick={throwBall}>
                                Throw Ball
                            </StyledButton>
                            <StyledLabel>
                                Pins Down: {getPinsDown}
                            </StyledLabel>
                        </InputColumnContainer>
                    </Container>
                )}
            </motion.div>
        </AwaitQuery>
    );
}

export default GamePage;