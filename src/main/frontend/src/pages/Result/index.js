import React from "react";
import { ReslutContainer, Frame } from "./style";
import Title from "assets/images/title.png";
import Femail from "assets/images/femail1.png";
import Male from "assets/images/male1.png";
import Heart from "assets/images/heart.png";
import { Link } from "react-router-dom";
import { IoCaretForward } from "@react-icons/all-files/io5/IoCaretForward";

const Result = () => {
    return (
        <ReslutContainer>
            <Frame>

                <div className="titleWrap">
                    <h1>우리는 얼마나 잘맞을까?</h1>
                    <img src={Title} alt="Title" />
                </div>
                
                <article>
                    <figure>
                        <img src={Femail} alt="femail" />
                        <dl>
                            <dt>name</dt>
                            <dd><Link to="#">사주 정보 자세히 보기 <span><IoCaretForward /></span></Link></dd>
                        </dl>
                    </figure>
                    <figure>
                        <img src={Heart} alt="heart" />
                    </figure>
                    <figure>
                        <img src={Male} alt="male" />
                        <dl>
                            <dt>name</dt>
                            <dd><Link to="#">사주 정보 자세히 보기 <span><IoCaretForward /></span></Link></dd>
                        </dl>
                    </figure>
                </article>

                
            </Frame>
        </ReslutContainer>
    )
}

export default Result;