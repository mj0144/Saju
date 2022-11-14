import React from "react";
import Title from "assets/images/title.png";
import Visual from "assets/images/visual.png";
import { MainContainer, Frame } from "./style";
import { Link } from "react-router-dom";


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
                    <Link to="/Info"><strong>테스트 시작!</strong></Link>
                </article>
            </Frame>
        </MainContainer>
    )
}

export default Main;