import styled from '@emotion/styled';

export const MainContainer = styled.section`
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

    & p{
        color: #6E6360;
        font-weight: 900;
        font-size: 20px;
    }

    & article{
        background-color: #EBAAB7;
        padding: 20px 40px;
        border-radius: 40px;
        margin-top: 40px;

        & strong{
            color: #fff;
            font-size: 20px;
            font-weight: 900;
            cursor: pointer;
        }

        & strong:hover{
            color: black;
        }
    }
`