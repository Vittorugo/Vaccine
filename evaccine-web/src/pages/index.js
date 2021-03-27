import Head from 'next/head'
import { Layout, Menu, Breadcrumb } from 'antd';
import "antd/dist/antd.css";
import ListaPessoas from '../components/ListaPessoas';


const { Header, Content, Footer} = Layout;

export default function Home() {
  return (
    <div>
      <Head>
        <title>Create Next App</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>

      <Layout className='layout'>
        <Header >
          <div className="logo">
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
              <Menu.Item key="1">
                Home
              </Menu.Item>
            </Menu>
          </div>
        </Header>
        <Content style={{padding: '0 50px'}}>
          <div className="site-layout-content">
            <ListaPessoas></ListaPessoas>
          </div>
        </Content>
        <Footer style={{textAlign: 'center'}}>
            Vaccine - Viva o SUS.
        </Footer>
      </Layout>
    </div>
  )
}
