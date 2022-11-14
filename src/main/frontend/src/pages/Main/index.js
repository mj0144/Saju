import React from "react";
import Title from "assets/images/title.png";
import Visual from "assets/images/visual.png";
import { MainContainer, Frame } from "./style";


const Main = () => {
    const num = 1930;

    return (
        <MainContainer>
            <Frame>
                <div>
                    <h1>우리는 얼마나 잘맞을까?</h1>
                    <img src={Title} alt="Title" />
                </div>
                
                <img src={Visual} alt="Visual" />
                <p>현재까지 {num}명이 참여했습니다.</p>

                <article>
                    <strong>테스트 시작!</strong>
                </article>
            </Frame>
        </MainContainer>
    )
}

export default Main;