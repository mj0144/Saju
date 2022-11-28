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
    height: 100%;
    background-color: #FBE8E7;
    margin: 6% auto 2%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 30px;
    text-align: center;
    border: 3px solid #9B6F73;

    
    .titleWrap{
        padding-top: 8%;
        &  h1{
            color: #9B6F73;
            font-size: 24px;
            font-weight: 900;
        }
    }

    & div:last-of-type{
        padding: 4% 0 8%;

        & button{
            border: 2px solid #9B6F73;
            background-color: #FBE8E7;
            padding: 1rem 3em;
            font-size: 2em;
            font-weight: 600;
            color: #6E6360;
            border-radius: 10px;
            cursor: pointer;
        }

        & button:hover{
            color: brown;
        }
    }
   
`

export const InsertInfo = styled.div`
    border: 1px solid #A58187;
    width: 90%;
    display: flex;
    flex-wrap: wrap;
    gap: 2em;
    position: relative;
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

    .noTime{
        width: 100%;
        line-height: 2;
        
        & input[type="checkbox"]{
            display: none;
        }

        input[type="checkbox"] + label{
            display: inline-block;
            width: 30px;
            height: 30px;
            border: 1px solid #A58187;
            position: relative;
            background-color: #fff;
            margin-right: 1rem;
            vertical-align: middle;
        }

        input[id="femailBorn"]:checked + label{
            background-color: #EBAAB7;
            border: 1px solid #fff;
        }

        input[id="femailBorn"]:checked + label::after{
            content: '✔';
            font-size: 24px;
            text-align: center;
            position: absolute;
            left: 6px;
            top: -6px;
            color: #fff;
        }

        input[id="maleBorn"]:checked + label{
            background-color: #EBAAB7;
            border: 1px solid #fff;
        }

        input[id="maleBorn"]:checked + label::after{
            content: '✔';
            font-size: 24px;
            text-align: center;
            position: absolute;
            left: 6px;
            top: -6px;
            color: #fff;
        }

        & span{
            color: #6E6360;
            font-size: 24px;
            font-weight: 600;
            vertical-align: sub;
        }
    }

`

export const SubmitForm = styled.form`
        display: flex;
        flex-direction: column;
        gap: 20px;
        width: 240px;
        padding-top: 4%;

        & dl{
            display: flex;
            align-items: center;
            font-size: 24px;
            font-weight: 900;
            gap: 32px;
            justify-content: flex-start;
            color: #6E6360;

            & dd{

                & label:first-of-type{
                    padding-right: 6px;
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

                input[id="femailOne"]:checked + label{
                    background-color: #EBAAB7;
                    border: 1px solid #fff;
                }

                input[id="maleOne"]:checked + label{
                    background-color: #EBAAB7;
                    border: 1px solid #fff;
                }

                input[id="femailOne"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
                    text-align: center;
                    position: absolute;
                    left: 4px;
                    top: 4px;
                    color: #fff;
                }

                input[id="maleOne"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
                    text-align: center;
                    position: absolute;
                    left: 4px;
                    top: 4px;
                    color: #fff;
                }
                
                input[id="femailTwo"]:checked + label{
                    background-color: #EBAAB7;
                    border: 1px solid #fff;
                }

                input[id="maleTwo"]:checked + label{
                    background-color: #EBAAB7;
                    border: 1px solid #fff;
                }

                input[id="femailTwo"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
                    text-align: center;
                    position: absolute;
                    left: 4px;
                    top: 4px;
                    color: #fff;
                }

                input[id="maleTwo"]:checked + label::after{
                    content:'✔';
                    font-size: 12px;
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

       


`