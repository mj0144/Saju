import styled from '@emotion/styled';

export const InfoContainer = styled.section`
    background-color: #F3B5BB;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
`

export const Frame = styled.div`
    max-width: 600px;
    width: 100%;
    height: 100vh;
    background-color: #FBE8E7;
    margin: 6% auto 2%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 30px;
    text-align: center;
    
    & div{
        &  h1{
            color: #9B6F73;
            font-size: 24px;
            font-weight: 900;
        }
    }
   
`

export const FemailInfo = styled.div`
    border: 1px solid #A58187;
    width: 90%;
    padding-bottom: 10%;
    display: flex;
    gap: 2em;
    justify-content: flex-end;

    & figure{
        border: 1px solid #9B6F73;
        border-radius: 50%;
        box-sizing: border-box;
        background-color: #fff;
        padding: 6%;
        position: relative;
        margin-top: 10%;

        & img{
            width: 140px;
            height: 140px;
        }

        & span{
            position: absolute;
            bottom: 0;
            right: 0;
            padding: 12px 12px 10px;
            background: #EBAAB7;
            border-radius: 50%;
            cursor: pointer;

            & svg{
                stroke-width: 2;
                color: white;
                font-size: 28px;
            }

        }

        & span:hover{
            opacity: 0.7;
        }
    }

    & form{
        display: flex;
        flex-direction: column;
        gap: 20px;
        width: 240px;
        padding-top: 4%;

        & dl{
            display: flex;
            align-items: baseline;
            font-size: 24px;
            font-weight: 900;
            gap: 40px;
            justify-content: flex-start;
            color: #6E6360;

            & dd{
                & input{
                    width: 18px;
                    height: 18px;
                }

                & input[type="checkbox"]{
                    display: none;
                }

                input[type="checkbox"] + label{
                    display: inline-block;
                    width: 18px;
                    height: 18px;
                    border: 1px solid #EBAAB7;
                    position: relative;
                    border-radius: 50%;
                    background-color: #fff;
                }

                input[id="femail"]:checked + label{
                    background-color: #EBAAB7;
                }

                input[id="male"]:checked + label{
                    background-color: #EBAAB7;
                }

                input[id="femail"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
                    width: 8px;
                    height: 8px;
                    text-align: center;
                    position: absolute;
                    left: 4px;
                    top: 4px;
                    color: #fff;
                }

                input[id="male"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
                    width: 8px;
                    height: 8px;
                    text-align: center;
                    position: absolute;
                    left: 4px;
                    top: 4px;
                    color: #fff;
                }

  
            }
        }

        & ul{
            text-align: left;
            display: flex;
            flex-direction: column;
            gap: 20px;

            & li{
                & input{
                    padding: 6% 4%;
                    width: 180px;
                    font-weight: 900;
                    font-size: 18px;
                    border: 2px solid #A58187;
                    background-color: rgba(255,255,255,0.5);
                }

                & input::placeholder{
                    color: #6E6360;
                }
            }
        }
    }

   

`


export const MalelInfo = styled.div`
    border: 1px solid #A58187;

`

export const SubmitForm = styled.form`


`