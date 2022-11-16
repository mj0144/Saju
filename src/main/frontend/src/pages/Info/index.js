import React from "react";
import Title from "assets/images/title.png";
import Femail from "assets/images/femail.png";
import Male from "assets/images/male.png";
import { BsPlus } from "@react-icons/all-files/bs/BsPlus";
import { InfoContainer, Frame, InsertInfo, SubmitForm } from "./style";

const Info = () =>{

    return (
        <InfoContainer>
            <Frame>
                <div>
                    <h1>우리는 얼마나 잘맞을까?</h1>
                    <img src={Title} alt="Title"/>
                </div>

                <InsertInfo>
                    <figure>
                        <img src={Femail} alt="Feamil"/>
                        <span><BsPlus /></span>
                    </figure>

                    <SubmitForm>
                        <dl>
                            <dt>
                                <label>성별</label>
                            </dt>
                            <dd>
                                <label>여</label>
                                <input type="checkbox" id="femailOne"/>
                                <label htmlFor="femailOne"></label>
                            </dd>
                            <dd>
                                <label>남</label>
                                <input type="checkbox" id="maleOne"/>
                                <label htmlFor="maleOne"></label>
                            </dd>
                        </dl>
                        <ul>
                            <li>
                                <input type="text" placeholder="이름"/>
                            </li>
                            <li>
                                <input type="text" placeholder="생년월일"/>
                            </li>
                            <li>
                                <input type="text" placeholder="태어난 시간"/>
                            </li>
                        </ul>
                       

                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="femailBorn"/>
                        <label htmlFor="femailBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <InsertInfo>
                    <figure>
                        <img src={Male} alt="Male" />
                        <span><BsPlus /></span>
                    </figure>

                    <SubmitForm>
                        <dl>
                            <dt>
                                <label>성별</label>
                            </dt>
                            <dd>
                                <label>여</label>
                                <input type="checkbox" id="femailTwo"/>
                                <label htmlFor="femailTwo"></label>
                            </dd>
                            <dd>
                                <label>남</label>
                                <input type="checkbox" id="maleTwo"/>
                                <label htmlFor="maleTwo"></label>
                            </dd>
                        </dl>
                        <ul>
                            <li>
                                <input type="text" placeholder="이름"/>
                            </li>
                            <li>
                                <input type="text" placeholder="생년월일"/>
                            </li>
                            <li>
                                <input type="text" placeholder="태어난 시간"/>
                            </li>
                        </ul>
                    </SubmitForm>

                    <p className="noTime">
                        <input type="checkbox" id="maleBorn"/>
                        <label htmlFor="maleBorn"></label>
                        <span>태어난 시간 모름</span>
                    </p>

                </InsertInfo>

                <div>
                    <button type="submit">결과보기</button>
                </div>
            </Frame>
        </InfoContainer>
    )
}

export default Info;