import React, {FC, useCallback, useEffect, useRef} from "react";
import {Container, Gif, InputRowContainer, StyledButton, StyledInput} from "../../shared/SharedStyles";
import {useNavigate} from "react-router";
import {useName, useSetName} from "../../store/playerSlice";
import {useStartGame} from "./useStartGame";

const StartPage: FC = () => {
    const name = useName();
    const setName = useSetName();
    const navigate = useNavigate();
    const inputRef = useRef<HTMLInputElement>(null);
    const {startGame, isStartSuccess} = useStartGame();

    const handleNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value);
    };

    const handleKeyDown = (e: React.KeyboardEvent<HTMLInputElement>) => {
        if (e.key === "Enter") {
            startGame(name);
        }
    };

    const onStartGame = useCallback(() => {
        navigate("/game");
    }, [navigate, isStartSuccess]);

    useEffect(() => {
        if (inputRef.current) {
            inputRef.current.focus();
        }
    }, []);

    return (
        <Container initial={{scale: 0}} animate={{
            scale: 1,
            transition: {duration: 1}
        }}>
            <Gif src="/bowling.jpg" alt="Bowling GIF"/>
            <InputRowContainer animate={{
                scale: 1,
                transition: {duration: 2}
            }}>
                <StyledInput
                    ref={inputRef}
                    type="text"
                    value={name}
                    onChange={handleNameChange}
                    onKeyDown={handleKeyDown}
                    placeholder="Enter your name"
                    initial={{scale: 0}} animate={{scale: 1, transition: {duration: 1}}}
                />
                <StyledButton initial={{scale: 0}} animate={{scale: 1, transition: {duration: 1}}} onClick={onStartGame}>
                    Start New Game
                </StyledButton>
            </InputRowContainer>

        </Container>
    )
}

export default StartPage;