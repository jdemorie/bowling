import {Container, Gif, InputColumnContainer, LabelLaunching} from "../../shared/SharedStyles";
import React from "react";

const Launching = () => {
    return (
        <Container>
            <Gif src="/pins.jpg" alt="Bowling GIF"/>
            <InputColumnContainer initial={{scale: 0}} animate={{
                scale: 1,
                transition: {duration: 2}
            }}>
                <LabelLaunching initial={{scale: 0}} animate={{
                    scale: 3,
                    transition: {duration: 3}
                }}>
                    Launching ball...
                </LabelLaunching>
            </InputColumnContainer>
        </Container>
    );
}

export default Launching;